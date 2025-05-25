package com.api.aplicacionesempresariales.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Data
public class ServicioCreateDto {

    @NotBlank
    private String estado;

    @NotNull
    @Positive
    private Double valor;

    @NotNull
    private String nombres;

    @NotNull
    private String descripcion;
}
