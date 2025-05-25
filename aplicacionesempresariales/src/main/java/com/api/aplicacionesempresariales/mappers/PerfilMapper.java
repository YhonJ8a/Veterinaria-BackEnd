package com.api.aplicacionesempresariales.mappers;

import com.api.aplicacionesempresariales.dtos.PerfilDto;
import com.api.aplicacionesempresariales.models.Perfil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PerfilMapper {
    private final ModelMapper mapper;

    public PerfilDto toDto(Perfil perfil) {
        return mapper.map(perfil, PerfilDto.class);
    }

    public Perfil toEntity(PerfilDto dto) {
        return mapper.map(dto, Perfil.class);
    }
}