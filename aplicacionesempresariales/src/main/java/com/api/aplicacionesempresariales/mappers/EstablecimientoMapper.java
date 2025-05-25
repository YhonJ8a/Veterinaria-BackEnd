package com.api.aplicacionesempresariales.mappers;

import com.api.aplicacionesempresariales.dtos.*;
import com.api.aplicacionesempresariales.models.Establecimiento;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstablecimientoMapper {
    private final ModelMapper mapper;

    public EstablecimientoDto toDto(Establecimiento entity) {
        return mapper.map(entity, EstablecimientoDto.class);
    }

    public Establecimiento toEntity(EstablecimientoCreateDto dto) {
        return mapper.map(dto, Establecimiento.class);
    }
}