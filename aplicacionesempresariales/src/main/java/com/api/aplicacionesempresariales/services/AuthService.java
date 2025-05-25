package com.api.aplicacionesempresariales.services;

import com.api.aplicacionesempresariales.dtos.JwtResponseDto;
import com.api.aplicacionesempresariales.dtos.LoginRequestDto;
import com.api.aplicacionesempresariales.dtos.UsuarioCreateDto;
import com.api.aplicacionesempresariales.dtos.UsuarioDto;

public interface AuthService {

    public JwtResponseDto login(LoginRequestDto dto);

    public UsuarioDto register(UsuarioCreateDto dto);

}
