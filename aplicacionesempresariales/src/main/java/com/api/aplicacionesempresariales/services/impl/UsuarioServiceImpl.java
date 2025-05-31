package com.api.aplicacionesempresariales.services.impl;

import com.api.aplicacionesempresariales.dtos.*;
import com.api.aplicacionesempresariales.mappers.PerfilMapper;
import com.api.aplicacionesempresariales.mappers.UsuarioMapper;
import com.api.aplicacionesempresariales.models.Usuario;
import com.api.aplicacionesempresariales.repositories.UsuarioRepository;
import com.api.aplicacionesempresariales.services.PerfilService;
import com.api.aplicacionesempresariales.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
    private final PerfilService perfilService;
    private final PerfilMapper perfilMapper;

    @Override
    public UsuarioDto create(UsuarioCreateDto dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        usuario.setPerfil(perfilMapper.toEntity(perfilService.findById(dto.getPerfilId())));
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }

    @Override
    public void delete(UUID id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        usuarioRepository.delete(usuario);
    }

    @Override
    public UsuarioDto findById(UUID id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }

    @Override
    public List<UsuarioDto> findAll() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDto autenticar(String correo, String password) {
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new IllegalArgumentException("Contraseña incorrecta");
        }

        return usuarioMapper.toDto(usuario);
    }

    @Override
    public void cambiarPassword(UUID id, String nuevoPassword) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        usuario.setPassword(passwordEncoder.encode(nuevoPassword));
        usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioDto update(UUID id, UsuarioUpdateDto dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        usuario.setNombres(dto.getNombres());
        usuario.setApellidos(dto.getApellidos());
        usuario.setFotoUrl(dto.getFotoUrl());
        usuario.setDni(dto.getDni());
        usuario.setCorreo(dto.getCorreo());
        usuario.setPerfil(perfilMapper.toEntity(perfilService.findById(dto.getPerfilId())));
        usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public List<UsuarioDto> buscarPorPerfil(String perfil) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorPerfil'");
    }

    @Override
    public UsuarioDto mapToDto(Usuario usuario) {
        return usuarioMapper.toDto(usuario);
    }

    // @Override
    // public List<UsuarioDto> buscarPorPerfil(String perfil) {
    // Perfil perfil = mapperPerfil.toDto(repo.findById(perfil).orElseThrow());
    // return usuarioRepository.findByPerfil(perfil).stream()
    // .map(usuarioMapper::entityToDto)
    // .collect(Collectors.toList());
    // }
}
