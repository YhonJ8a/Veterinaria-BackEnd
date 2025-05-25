package com.api.aplicacionesempresariales.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.aplicacionesempresariales.dtos.EstablecimientoCreateDto;
import com.api.aplicacionesempresariales.dtos.EstablecimientoDto;
import com.api.aplicacionesempresariales.mappers.EstablecimientoMapper;
import com.api.aplicacionesempresariales.models.Establecimiento;
import com.api.aplicacionesempresariales.repositories.EstablecimientoRepository;
import com.api.aplicacionesempresariales.services.EstablecimientoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class EstablecimientoServiceImpl implements EstablecimientoService {
    private final EstablecimientoRepository repo;
    private final EstablecimientoMapper mapper;

    public EstablecimientoDto create(EstablecimientoCreateDto dto) {
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

    public EstablecimientoDto update(UUID id, EstablecimientoCreateDto dto) {
        Establecimiento e = repo.findById(id).orElseThrow();
        e.setNombre(dto.getNombre());
        e.setDireccion(dto.getDireccion());
        e.setDepartamento(dto.getDepartamento());
        e.setStartTime(dto.getStartTime());
        e.setEndTime(dto.getEndTime());
        return mapper.toDto(repo.save(e));
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

    public EstablecimientoDto findById(UUID id) {
        return mapper.toDto(repo.findById(id).orElseThrow());
    }

    public List<EstablecimientoDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}