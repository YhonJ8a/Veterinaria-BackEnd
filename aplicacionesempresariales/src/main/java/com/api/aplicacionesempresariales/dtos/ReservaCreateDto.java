package com.api.aplicacionesempresariales.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Data
public class ReservaCreateDto {
    @NotNull
    private UUID id;

    @NotBlank
    private String estado;

    @NotNull
    private UUID usuarioId;

    @NotNull
    private UUID funcionarioId;
}
