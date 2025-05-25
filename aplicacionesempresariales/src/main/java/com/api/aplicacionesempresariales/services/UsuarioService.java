package com.api.aplicacionesempresariales.services;

import java.util.List;
import java.util.UUID;

import com.api.aplicacionesempresariales.dtos.UsuarioCreateDto;
import com.api.aplicacionesempresariales.dtos.UsuarioDto;
import com.api.aplicacionesempresariales.dtos.UsuarioUpdateDto;
import com.api.aplicacionesempresariales.models.Usuario;

public interface UsuarioService {

    public UsuarioDto create(UsuarioCreateDto dto);

    public UsuarioDto update(UUID id, UsuarioUpdateDto dto);

    public void delete(UUID id);

    public UsuarioDto findById(UUID id);

    public List<UsuarioDto> findAll();

    public UsuarioDto autenticar(String correo, String password);

    public void cambiarPassword(UUID id, String nuevoPassword);

    public List<UsuarioDto> buscarPorPerfil(String perfil);

    UsuarioDto mapToDto(Usuario usuario);
}
