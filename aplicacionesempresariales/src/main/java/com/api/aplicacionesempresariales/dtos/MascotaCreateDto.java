package com.api.aplicacionesempresariales.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class MascotaCreateDto {
    @NotBlank
    private String nombres;

    @NotBlank
    private String identificacion;

    @NotNull
    private LocalDate fechaNac;

    private String fotoUrl;

    @NotNull
    private UUID responsableId;
}
