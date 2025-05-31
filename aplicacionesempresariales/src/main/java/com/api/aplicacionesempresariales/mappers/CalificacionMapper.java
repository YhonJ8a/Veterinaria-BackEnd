package com.api.aplicacionesempresariales.mappers;

import com.api.aplicacionesempresariales.dtos.*;
import com.api.aplicacionesempresariales.models.Calificacion;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CalificacionMapper {
    private final ModelMapper mapper;

    public CalificacionDto toDto(Calificacion entity) {
        return mapper.map(entity, CalificacionDto.class);
    }

    public CalificacionSimpleDto toSimpleDto(Calificacion entity) {
        return mapper.map(entity, CalificacionSimpleDto.class);
    }

    public Calificacion toEntity(CalificacionCreateDto dto) {
        return mapper.map(dto, Calificacion.class);
    }
}
