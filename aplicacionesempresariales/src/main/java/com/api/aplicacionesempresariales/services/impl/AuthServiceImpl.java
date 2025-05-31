package com.api.aplicacionesempresariales.services.impl;

import com.api.aplicacionesempresariales.core.JwtManager;
import com.api.aplicacionesempresariales.dtos.*;
import com.api.aplicacionesempresariales.mappers.PerfilMapper;
import com.api.aplicacionesempresariales.mappers.UsuarioMapper;
import com.api.aplicacionesempresariales.models.Usuario;
import com.api.aplicacionesempresariales.repositories.UsuarioRepository;
import com.api.aplicacionesempresariales.services.AuthService;
import com.api.aplicacionesempresariales.services.PerfilService;
import com.api.aplicacionesempresariales.services.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtManager jwtTokenProvider;
    private final UsuarioService usuarioService;
    private final PerfilService perfilService;
    private final UsuarioMapper usuarioMapper;
    private final PerfilMapper perfilMapper;

    @Override
    public JwtResponseDto login(LoginRequestDto dto) {
        System.out.println("Authentication: " + dto.getCorreo() + " // " + dto.getPassword());

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getCorreo(), dto.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            Usuario usuario = usuarioRepository.findByCorreo(dto.getCorreo())
                    .orElseThrow(() -> new IllegalArgumentException("Credenciales inválidas"));

            String token = jwtTokenProvider.generateToken(usuario);
            // String refreshToken = jwtTokenProvider.generateRefreshToken(authentication);

            return JwtResponseDto.builder()
                    .accessToken(token)
                    // .refreshToken(refreshToken)
                    .usuario(usuarioService.mapToDto(usuario))
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Credenciales inválidas");
        }
    }

    @Override
    @Transactional
    public UsuarioDto register(UsuarioCreateDtoUser dto) {
        if (usuarioRepository.findByCorreo(dto.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado");
        }
        Usuario usuario = usuarioMapper.toEntity(dto);
        usuario.setPerfil(perfilMapper.toEntity(perfilService.findByPerfil("USUARIO_FINAL")));
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        System.out.println("Usuario a registrar: " + usuario);
        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }

}
