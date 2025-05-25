package com.api.aplicacionesempresariales.services.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.aplicacionesempresariales.dtos.HorarioCreateDto;
import com.api.aplicacionesempresariales.dtos.HorarioDto;
import com.api.aplicacionesempresariales.mappers.HorarioMapper;
import com.api.aplicacionesempresariales.models.Horario;
import com.api.aplicacionesempresariales.repositories.HorarioRepository;
import com.api.aplicacionesempresariales.services.HorarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class HorarioServiceImpl implements HorarioService {
    private final HorarioRepository repo;
    private final HorarioMapper mapper;

    public HorarioDto create(HorarioCreateDto dto) {
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

    public HorarioDto update(UUID id, HorarioCreateDto dto) {
        Horario h = repo.findById(id).orElseThrow();
        h.setFecha(dto.getFecha());
        h.setHora(dto.getHora());
        h.setDuracion(dto.getDuracion());
        return mapper.toDto(repo.save(h));
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

    public HorarioDto findById(UUID id) {
        return mapper.toDto(repo.findById(id).orElseThrow());
    }

    public List<HorarioDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<HorarioDto> buscarPorFuncionario(UUID funcionarioId, LocalDate fecha) {
        return repo.findByFuncionarioIdAndFecha(funcionarioId, fecha).stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public List<HorarioDto> buscarPorFecha(LocalDate fecha) {
        return repo.findByFecha(fecha).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<HorarioDto> buscarPorFuncionario(UUID funcionarioId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorFuncionario'");
    }

    @Override
    public List<HorarioDto> buscarPorFecha(Date fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorFecha'");
    }
}
