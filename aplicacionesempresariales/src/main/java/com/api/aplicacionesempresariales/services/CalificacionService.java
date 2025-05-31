package com.api.aplicacionesempresariales.services;

import java.util.List;
import java.util.UUID;

import com.api.aplicacionesempresariales.dtos.CalificacionCreateDto;
import com.api.aplicacionesempresariales.dtos.CalificacionDto;
import com.api.aplicacionesempresariales.dtos.CalificacionSimpleDto;

public interface CalificacionService {
    public CalificacionDto create(CalificacionCreateDto dto);

    public void delete(UUID id);

    public CalificacionDto findById(UUID id);

    public List<CalificacionDto> findAll();

    public List<CalificacionSimpleDto> calificacionesByIdReserva(UUID id);

    public double promedioCalificaciones();
}
