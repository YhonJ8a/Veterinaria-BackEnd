package com.api.aplicacionesempresariales.services;

import java.util.List;
import java.util.UUID;

import com.api.aplicacionesempresariales.dtos.CalificacionCreateDto;
import com.api.aplicacionesempresariales.dtos.CalificacionDto;

public interface CalificacionService {
    public CalificacionDto create(CalificacionCreateDto dto);

    public void delete(UUID id);

    public CalificacionDto findById(UUID id);

    public List<CalificacionDto> findAll();

    public double promedioCalificaciones();
}
