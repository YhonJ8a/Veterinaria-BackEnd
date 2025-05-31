package com.api.aplicacionesempresariales.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Data
public class CalificacionCreateDto {

    private String comentario = "";

    private UUID reservaId;

    @Min(1)
    @Max(5)
    private int estrellas = 4;
}
