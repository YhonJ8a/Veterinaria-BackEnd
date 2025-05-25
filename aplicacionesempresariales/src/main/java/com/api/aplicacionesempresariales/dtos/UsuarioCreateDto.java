package com.api.aplicacionesempresariales.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UsuarioCreateDto {
    @NotBlank
    private String nombres;

    @NotBlank
    private String apellidos;

    @NotBlank
    private String dni;

    @NotNull
    private UUID perfilId;

    @NotNull
    private LocalDate fechaNac;

    private String fotoUrl;

    @Email
    @NotBlank
    private String correo;

    @NotBlank
    private String password;

    // private String agenda;

    // private UUID establecimientoId;
}
