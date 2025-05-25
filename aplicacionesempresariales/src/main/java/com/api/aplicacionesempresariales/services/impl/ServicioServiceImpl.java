package com.api.aplicacionesempresariales.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.aplicacionesempresariales.dtos.ServicioCreateDto;
import com.api.aplicacionesempresariales.dtos.ServicioDto;
import com.api.aplicacionesempresariales.mappers.ServicioMapper;
import com.api.aplicacionesempresariales.models.Servicio;
import com.api.aplicacionesempresariales.repositories.ServicioRepository;
import com.api.aplicacionesempresariales.services.ServicioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class ServicioServiceImpl implements ServicioService {
    private final ServicioRepository repo;
    private final ServicioMapper mapper;

    public ServicioDto create(ServicioCreateDto dto) {
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

    public ServicioDto update(UUID id, ServicioCreateDto dto) {
        Servicio s = repo.findById(id).orElseThrow();
        s.setEstado(dto.getEstado());
        s.setValor(dto.getValor());
        return mapper.toDto(repo.save(s));
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

    public ServicioDto findById(UUID id) {
        return mapper.toDto(repo.findById(id).orElseThrow());
    }

    public List<ServicioDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}