package com.api.aplicacionesempresariales.mappers;

import com.api.aplicacionesempresariales.dtos.*;
import com.api.aplicacionesempresariales.models.Reserva;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservaMapper {
    private final ModelMapper mapper;

    public ReservaDto toDto(Reserva entity) {
        return mapper.map(entity, ReservaDto.class);
    }

    public Reserva toEntity(ReservaCreateDto dto) {
        return mapper.map(dto, Reserva.class);
    }

    public void updateEntity(ReservaUpdateDto dto, Reserva reserva) {
        mapper.getConfiguration().setSkipNullEnabled(true);
        mapper.map(dto, reserva);
    }
}