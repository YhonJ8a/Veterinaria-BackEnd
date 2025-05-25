package com.api.aplicacionesempresariales.services;

import java.util.List;
import java.util.UUID;

import com.api.aplicacionesempresariales.dtos.ServicioCreateDto;
import com.api.aplicacionesempresariales.dtos.ServicioDto;

public interface ServicioService {

    public ServicioDto create(ServicioCreateDto dto);

    public void delete(UUID id);

    public ServicioDto findById(UUID id);

    public List<ServicioDto> findAll();
}
