package com.api.aplicacionesempresariales.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioCreateDtoUser {
    @NotBlank
    private String nombres;

    @NotBlank
    private String apellidos;

    @NotBlank
    private String dni;

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
