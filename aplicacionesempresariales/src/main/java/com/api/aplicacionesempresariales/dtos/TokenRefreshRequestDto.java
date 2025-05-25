package com.api.aplicacionesempresariales.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TokenRefreshRequestDto {
    @NotBlank
    private String refreshToken;
}