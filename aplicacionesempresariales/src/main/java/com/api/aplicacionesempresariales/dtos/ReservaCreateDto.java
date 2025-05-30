package com.api.aplicacionesempresariales.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class ReservaCreateDto {

    @NotNull
    private UUID funcionarioId;

    @NotNull
    private UUID servicioId;

    @NotNull
    private UUID mascotaId;

    @NotNull
    private LocalDate fecha;

    @NotNull
    private LocalTime hora;

    @Min(1)
    private int duracion;

}
