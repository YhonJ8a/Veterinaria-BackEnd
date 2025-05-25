package com.api.aplicacionesempresariales.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Data
public class CalificacionCreateDto {
    @NotBlank
    private String comentario;

    @NotNull
    private UUID reservaId;
}
