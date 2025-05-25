package com.api.aplicacionesempresariales.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.aplicacionesempresariales.dtos.PerfilDto;
import com.api.aplicacionesempresariales.mappers.PerfilMapper;
import com.api.aplicacionesempresariales.models.Perfil;
import com.api.aplicacionesempresariales.repositories.PerfilRepository;
import com.api.aplicacionesempresariales.services.PerfilService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class PerfilServiceImpl implements PerfilService {
    private final PerfilRepository repo;
    private final PerfilMapper mapper;

    public PerfilDto create(PerfilDto dto) {
        Perfil entity = mapper.toEntity(dto);
        return mapper.toDto(repo.save(entity));
    }

    public PerfilDto update(UUID id, PerfilDto dto) {
        Perfil perfil = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Perfil no encontrado"));
        perfil.setPerfil(dto.getPerfil());
        return mapper.toDto(repo.save(perfil));
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

    public PerfilDto findById(UUID id) {
        return mapper.toDto(repo.findById(id).orElseThrow());
    }

    public List<PerfilDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}