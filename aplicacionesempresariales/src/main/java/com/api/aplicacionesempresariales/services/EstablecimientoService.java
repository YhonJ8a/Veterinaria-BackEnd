package com.api.aplicacionesempresariales.services;

import java.util.List;
import java.util.UUID;

import com.api.aplicacionesempresariales.dtos.EstablecimientoCreateDto;
import com.api.aplicacionesempresariales.dtos.EstablecimientoDto;
import com.api.aplicacionesempresariales.dtos.ServicioPorEstablecimientoCreateDto;
import com.api.aplicacionesempresariales.dtos.ServicioPorEstablecimientoDto;

public interface EstablecimientoService {

    public EstablecimientoDto create(EstablecimientoCreateDto dto);

    public EstablecimientoDto update(UUID id, EstablecimientoCreateDto dto);

    public void delete(UUID id);

    public EstablecimientoDto findById(UUID id);

    public List<EstablecimientoDto> findAll();

    public List<ServicioPorEstablecimientoDto> findServiciosById(UUID id);

    public ServicioPorEstablecimientoDto createService(UUID id, ServicioPorEstablecimientoCreateDto dto);
}
