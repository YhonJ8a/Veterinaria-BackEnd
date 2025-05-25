package com.api.aplicacionesempresariales.mappers;

import com.api.aplicacionesempresariales.dtos.*;
import com.api.aplicacionesempresariales.models.Servicio;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServicioMapper {
    private final ModelMapper mapper;

    public ServicioDto toDto(Servicio entity) {
        return mapper.map(entity, ServicioDto.class);
    }

    public Servicio toEntity(ServicioCreateDto dto) {
        return mapper.map(dto, Servicio.class);
    }
}
