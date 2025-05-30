package com.api.aplicacionesempresariales.mappers;

import com.api.aplicacionesempresariales.dtos.*;
import com.api.aplicacionesempresariales.models.Usuario;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioMapper {
    private final ModelMapper mapper;

    // public UsuarioDto toDto(Usuario usuario) {
    // mapper.typeMap(Usuario.class, UsuarioDto.class).addMappings(mapper -> {
    // mapper.skip(UsuarioDto::setPassword);
    // });
    // return mapper.map(usuario, UsuarioDto.class);
    // }

    // @PostConstruct
    // public void init() {
    // mapper.typeMap(Usuario.class, UsuarioDto.class).addMappings(m ->
    // m.skip("password"));
    // }

    public UsuarioDto toDto(Usuario usuario) {
        return mapper.map(usuario, UsuarioDto.class);
    }

    public Usuario toEntity(UsuarioCreateDto dto) {
        return mapper.map(dto, Usuario.class);
    }

    public Usuario toEntity(UsuarioCreateDtoUser dto) {
        return mapper.map(dto, Usuario.class);
    }

    public void updateEntity(UsuarioUpdateDto dto, Usuario usuario) {
        mapper.getConfiguration().setSkipNullEnabled(true);
        mapper.map(dto, usuario);
    }
}