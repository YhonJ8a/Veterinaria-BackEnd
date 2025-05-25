package com.api.aplicacionesempresariales.services;

import java.util.List;
import java.util.UUID;

import com.api.aplicacionesempresariales.dtos.PerfilDto;

public interface PerfilService {

    public PerfilDto create(PerfilDto dto);

    public PerfilDto update(UUID id, PerfilDto dto);

    public void delete(UUID id);

    public PerfilDto findById(UUID id);

    public List<PerfilDto> findAll();
}
