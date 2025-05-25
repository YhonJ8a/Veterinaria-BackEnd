package com.api.aplicacionesempresariales.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class HorarioCreateDto {
    @NotNull
    private LocalDate fecha;

    @NotNull
    private LocalTime hora;

    @Min(1)
    private int duracion;

    @NotNull
    private UUID funcionarioId;
}
