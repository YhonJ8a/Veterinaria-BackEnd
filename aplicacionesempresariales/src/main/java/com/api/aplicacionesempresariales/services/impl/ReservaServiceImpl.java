package com.api.aplicacionesempresariales.services.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.aplicacionesempresariales.dtos.ReservaCreateDto;
import com.api.aplicacionesempresariales.dtos.ReservaDto;
import com.api.aplicacionesempresariales.dtos.ReservaUpdateDto;
import com.api.aplicacionesempresariales.mappers.HorarioMapper;
import com.api.aplicacionesempresariales.mappers.ReservaMapper;
import com.api.aplicacionesempresariales.models.Horario;
import com.api.aplicacionesempresariales.models.Usuario;
import com.api.aplicacionesempresariales.models.Reserva;
import com.api.aplicacionesempresariales.repositories.HorarioRepository;
import com.api.aplicacionesempresariales.repositories.MascotaRepository;
import com.api.aplicacionesempresariales.repositories.ReservaRepository;
import com.api.aplicacionesempresariales.repositories.ServicioPorEstablecimientoRepository;
import com.api.aplicacionesempresariales.repositories.ServicioRepository;
import com.api.aplicacionesempresariales.repositories.UsuarioRepository;
import com.api.aplicacionesempresariales.services.ReservaService;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository repo;
    private final ReservaMapper mapper;
    private final HorarioMapper mapper_h;
    private final UsuarioRepository usuarioRepository;
    private final HorarioRepository horarioRepository;
    private final MascotaRepository masciotaRepository;
    private final ServicioPorEstablecimientoRepository repoServicesXE;

    // PARECE SER ESTA TOMANDO COMO LLAVES PRINCIPALES A LOS IDS DE USUARIO Y
    // MASCOTA
    // EN VEZ DE A LA RESERVA, POR ESO NO SE PUEDE CREAR UNA NUEVA RESERVA

    public ReservaDto create(ReservaCreateDto dto) {

        System.out.println("ReservaCreateDto: " + dto);
        Horario horario = mapper_h.toSuperEntity(dto);
        Usuario usuario = usuarioRepository.findById(dto.getFuncionarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        horario.setFuncionario(usuario);

        LocalTime horaFin = dto.getHora().plusMinutes(dto.getDuracion());
        List<Horario> disponibilidad = horarioRepository.disponibilidad(
                dto.getFuncionarioId(),
                dto.getFecha(),
                dto.getHora(),
                horaFin);
        if (disponibilidad.size() > 0) {
            throw new IllegalArgumentException("El horario no está disponible");
        }
        horario.setHoraStar(dto.getHora());
        horario.setHoraEnd(horaFin);
        Horario horarioGuardado = horarioRepository.save(horario);

        if (repo.existsByHorarioAndMascota(horarioGuardado,
                masciotaRepository.findById(dto.getMascotaId()).orElseThrow())) {
            horarioRepository.delete(horarioGuardado);
            throw new IllegalArgumentException("Ya existe una reserva para ese horario y mascota");
        }

        try {
            Reserva reserva = new Reserva();
            reserva.setEstado("PENDIENTE");
            reserva.setFuncionario(usuario);
            reserva.setHorario(horarioGuardado);
            reserva.setMascota(masciotaRepository.findById(dto.getMascotaId()).orElseThrow());
            reserva.setServicio(repoServicesXE.findById(dto.getServicioId()).orElseThrow());

            return mapper.toDto(repo.save(reserva));
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al crear la reserva: " + e.getMessage());
        }
    }

    public ReservaDto update(UUID id, ReservaUpdateDto dto) {
        Reserva r = repo.findById(id).orElseThrow();
        mapper.updateEntity(dto, r);
        return mapper.toDto(repo.save(r));
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

    public ReservaDto findById(UUID id) {
        return mapper.toDto(repo.findById(id).orElseThrow());
    }

    public List<ReservaDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public void confirmar(UUID id) {
        Reserva r = repo.findById(id).orElseThrow();
        r.setEstado("CONFIRMADA");
        repo.save(r);
    }

    public void cancelar(UUID id) {
        Reserva r = repo.findById(id).orElseThrow();
        r.setEstado("CANCELADA");
        repo.save(r);
    }

    public List<ReservaDto> buscarPorEstado(String estado) {
        return repo.findByEstado(estado).stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
