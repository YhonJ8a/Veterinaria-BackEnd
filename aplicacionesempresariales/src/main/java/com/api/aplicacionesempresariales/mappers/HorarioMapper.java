package com.api.aplicacionesempresariales.mappers;

import com.api.aplicacionesempresariales.dtos.*;
import com.api.aplicacionesempresariales.models.Horario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HorarioMapper {
    private final ModelMapper mapper;

    public HorarioDto toDto(Horario entity) {
        return mapper.map(entity, HorarioDto.class);
    }

    public Horario toEntity(HorarioCreateDto dto) {
        return mapper.map(dto, Horario.class);
    }
}