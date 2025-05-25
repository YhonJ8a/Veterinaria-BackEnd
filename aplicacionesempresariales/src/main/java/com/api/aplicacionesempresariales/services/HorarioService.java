package com.api.aplicacionesempresariales.services;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.api.aplicacionesempresariales.dtos.HorarioCreateDto;
import com.api.aplicacionesempresariales.dtos.HorarioDto;

public interface HorarioService {
    public HorarioDto create(HorarioCreateDto dto);

    public HorarioDto update(UUID id, HorarioCreateDto dto);

    public void delete(UUID id);

    public HorarioDto findById(UUID id);

    public List<HorarioDto> findAll();

    public List<HorarioDto> buscarPorFuncionario(UUID funcionarioId);

    public List<HorarioDto> buscarPorFecha(Date fecha);
}
