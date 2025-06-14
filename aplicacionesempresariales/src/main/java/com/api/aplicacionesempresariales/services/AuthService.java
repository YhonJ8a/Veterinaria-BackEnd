package com.api.aplicacionesempresariales.services;

import com.api.aplicacionesempresariales.dtos.JwtResponseDto;
import com.api.aplicacionesempresariales.dtos.LoginRequestDto;
import com.api.aplicacionesempresariales.dtos.UserEstablecimientoCreateDto;
import com.api.aplicacionesempresariales.dtos.UsuarioCreateDtoUser;
import com.api.aplicacionesempresariales.dtos.UsuarioDto;

public interface AuthService {

    public JwtResponseDto login(LoginRequestDto dto);

    public UsuarioDto register(UsuarioCreateDtoUser dto);

    public UsuarioDto registerEstablecimiento(UserEstablecimientoCreateDto dto);
}
