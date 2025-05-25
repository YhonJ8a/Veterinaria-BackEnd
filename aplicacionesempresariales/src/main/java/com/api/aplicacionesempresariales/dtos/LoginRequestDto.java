package com.api.aplicacionesempresariales.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequestDto {
    @NotBlank
    private String correo;

    @NotBlank
    private String password;
}