package com.api.aplicacionesempresariales.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.aplicacionesempresariales.dtos.MascotaCreateDto;
import com.api.aplicacionesempresariales.dtos.MascotaDto;
import com.api.aplicacionesempresariales.dtos.MascotaUpdateDto;
import com.api.aplicacionesempresariales.mappers.MascotaMapper;
import com.api.aplicacionesempresariales.models.Mascota;
import com.api.aplicacionesempresariales.models.Usuario;
import com.api.aplicacionesempresariales.repositories.MascotaRepository;
import com.api.aplicacionesempresariales.repositories.ServicioRepository;
import com.api.aplicacionesempresariales.repositories.UsuarioRepository;
import com.api.aplicacionesempresariales.services.MascotaService;
import com.api.aplicacionesempresariales.services.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class MascotaServiceImpl implements MascotaService {
    private final MascotaRepository repo;
    private final MascotaMapper mapper;
    private final UsuarioRepository usuarioRepository;

    public MascotaDto create(MascotaCreateDto dto) {
        Mascota mascota = mapper.toEntity(dto);
        Usuario usuario = usuarioRepository.findById(dto.getResponsableId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        mascota.setResponsable(usuario);
        mascota.setCreatedAt(java.time.LocalDateTime.now());
        return mapper.toDto(repo.save(mascota));
    }

    public MascotaDto update(UUID id, MascotaUpdateDto dto) {
        Mascota mascota = repo.findById(id).orElseThrow();
        mapper.updateEntity(dto, mascota);
        return mapper.toDto(repo.save(mascota));
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

    public MascotaDto findById(UUID id) {
        return mapper.toDto(repo.findById(id).orElseThrow());
    }

    public List<MascotaDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<MascotaDto> buscarPorResponsable(UUID responsableId) {
        return repo.findByResponsableId(responsableId).stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
