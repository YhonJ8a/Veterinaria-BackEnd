package com.api.aplicacionesempresariales.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponseDto {
    // private String token;
    // private String refreshToken;
    // private String tokenType;
    // private String username;
    // private String perfil;
    // private String establecimiento;
    private String accessToken;
    private UsuarioDto usuario;
}
