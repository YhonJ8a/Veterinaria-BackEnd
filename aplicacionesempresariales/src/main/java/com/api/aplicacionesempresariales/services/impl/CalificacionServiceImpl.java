package com.api.aplicacionesempresariales.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.aplicacionesempresariales.dtos.CalificacionCreateDto;
import com.api.aplicacionesempresariales.dtos.CalificacionDto;
import com.api.aplicacionesempresariales.mappers.CalificacionMapper;
import com.api.aplicacionesempresariales.repositories.CalificacionRepository;
import com.api.aplicacionesempresariales.services.CalificacionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class CalificacionServiceImpl implements CalificacionService {
    private final CalificacionRepository repo;
    private final CalificacionMapper mapper;

    public CalificacionDto create(CalificacionCreateDto dto) {
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

    public CalificacionDto findById(UUID id) {
        return mapper.toDto(repo.findById(id).orElseThrow());
    }

    public List<CalificacionDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public double promedioCalificaciones() {
        return repo.findAll().stream().mapToInt(c -> c.getReserva().getId() != null ? 1 : 0).average().orElse(0);
    }
}
