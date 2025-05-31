package com.api.aplicacionesempresariales.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.aplicacionesempresariales.dtos.CalificacionCreateDto;
import com.api.aplicacionesempresariales.dtos.CalificacionDto;
import com.api.aplicacionesempresariales.dtos.CalificacionSimpleDto;
import com.api.aplicacionesempresariales.mappers.CalificacionMapper;
import com.api.aplicacionesempresariales.models.Calificacion;
import com.api.aplicacionesempresariales.repositories.CalificacionRepository;
import com.api.aplicacionesempresariales.repositories.ReservaRepository;
import com.api.aplicacionesempresariales.services.CalificacionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class CalificacionServiceImpl implements CalificacionService {
    private final CalificacionRepository repo;
    private final CalificacionMapper mapper;
    private final ReservaRepository repoRe;

    public CalificacionDto create(CalificacionCreateDto dto) {
        Calificacion calificacion = mapper.toEntity(dto);
        calificacion.setReserva(repoRe.findById(dto.getReservaId()).orElseThrow());
        return mapper.toDto(repo.save(calificacion));
    }

    public List<CalificacionSimpleDto> calificacionesByIdReserva(UUID id) {
        return repo.findByReservaId(id).stream()
                .map(mapper::toSimpleDto)
                .collect(Collectors.toList());
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
