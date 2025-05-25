package com.api.aplicacionesempresariales.services;

import java.util.List;
import java.util.UUID;

import com.api.aplicacionesempresariales.dtos.EstablecimientoCreateDto;
import com.api.aplicacionesempresariales.dtos.EstablecimientoDto;

public interface EstablecimientoService {

    public EstablecimientoDto create(EstablecimientoCreateDto dto);

    public EstablecimientoDto update(UUID id, EstablecimientoCreateDto dto);

    public void delete(UUID id);

    public EstablecimientoDto findById(UUID id);

    public List<EstablecimientoDto> findAll();
}
