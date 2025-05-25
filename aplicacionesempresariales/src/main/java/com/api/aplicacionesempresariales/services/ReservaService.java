package com.api.aplicacionesempresariales.services;

import java.util.List;
import java.util.UUID;

import com.api.aplicacionesempresariales.dtos.ReservaCreateDto;
import com.api.aplicacionesempresariales.dtos.ReservaDto;
import com.api.aplicacionesempresariales.dtos.ReservaUpdateDto;

public interface ReservaService {
    public ReservaDto create(ReservaCreateDto dto);

    public ReservaDto update(UUID id, ReservaUpdateDto dto);

    public void delete(UUID id);

    public ReservaDto findById(UUID id);

    public List<ReservaDto> findAll();

    public void confirmar(UUID id);

    public void cancelar(UUID id);

    public List<ReservaDto> buscarPorEstado(String estado);
}
