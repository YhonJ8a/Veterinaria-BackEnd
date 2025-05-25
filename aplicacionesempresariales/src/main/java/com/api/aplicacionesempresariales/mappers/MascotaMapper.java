package com.api.aplicacionesempresariales.mappers;

import com.api.aplicacionesempresariales.dtos.*;
import com.api.aplicacionesempresariales.models.Mascota;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MascotaMapper {
    private final ModelMapper mapper;

    public MascotaDto toDto(Mascota mascota) {
        return mapper.map(mascota, MascotaDto.class);
    }

    public Mascota toEntity(MascotaCreateDto dto) {
        return mapper.map(dto, Mascota.class);
    }

    public void updateEntity(MascotaUpdateDto dto, Mascota mascota) {
        mapper.getConfiguration().setSkipNullEnabled(true);
        mapper.map(dto, mascota);
    }
}