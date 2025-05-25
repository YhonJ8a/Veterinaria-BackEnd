package com.api.aplicacionesempresariales.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalTime;

@Data
public class EstablecimientoCreateDto {
    @NotBlank
    private String nombre;

    @NotBlank
    private String direccion;

    @NotBlank
    private String departamento;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;
}
