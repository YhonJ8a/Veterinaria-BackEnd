package com.api.aplicacionesempresariales.mappers;

import com.api.aplicacionesempresariales.dtos.*;
import com.api.aplicacionesempresariales.models.Establecimiento;
import com.api.aplicacionesempresariales.models.Servicio;
import com.api.aplicacionesempresariales.models.ServicioPorEstablecimiento;

import lombok.RequiredArgsConstructor;

import java.util.List;

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

    public ServicioPorEstablecimientoDto toSxEDto(ServicioPorEstablecimiento entity) {
        return mapper.map(entity, ServicioPorEstablecimientoDto.class);
    }

    public List<ServicioPorEstablecimientoDto> toSxEDtos(List<ServicioPorEstablecimiento> entities) {
        return entities.stream().map(this::toSxEDto).toList();
    }

    public List<Servicio> toSeEDtos(List<ServicioPorEstablecimiento> entities) {
        return entities.stream().map(ServicioPorEstablecimiento::getServicio).toList();
    }

    public ServicioPorEstablecimiento toEntityService(ServicioPorEstablecimientoCreateDto dto) {
        return mapper.map(dto, ServicioPorEstablecimiento.class);
    }
}