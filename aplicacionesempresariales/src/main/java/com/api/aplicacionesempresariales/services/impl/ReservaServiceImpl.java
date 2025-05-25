package com.api.aplicacionesempresariales.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.aplicacionesempresariales.dtos.ReservaCreateDto;
import com.api.aplicacionesempresariales.dtos.ReservaDto;
import com.api.aplicacionesempresariales.dtos.ReservaUpdateDto;
import com.api.aplicacionesempresariales.mappers.ReservaMapper;
import com.api.aplicacionesempresariales.models.Reserva;
import com.api.aplicacionesempresariales.repositories.ReservaRepository;
import com.api.aplicacionesempresariales.services.ReservaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository repo;
    private final ReservaMapper mapper;

    public ReservaDto create(ReservaCreateDto dto) {
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
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
