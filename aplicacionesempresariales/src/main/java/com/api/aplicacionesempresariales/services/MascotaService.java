package com.api.aplicacionesempresariales.services;

import java.util.List;
import java.util.UUID;

import com.api.aplicacionesempresariales.dtos.MascotaCreateDto;
import com.api.aplicacionesempresariales.dtos.MascotaDto;
import com.api.aplicacionesempresariales.dtos.MascotaUpdateDto;

public interface MascotaService {
    public MascotaDto create(MascotaCreateDto dto);

    public MascotaDto update(UUID id, MascotaUpdateDto dto);

    public void delete(UUID id);

    public MascotaDto findById(UUID id);

    public List<MascotaDto> findAll();

    public List<MascotaDto> buscarPorResponsable(UUID responsableId);
}
