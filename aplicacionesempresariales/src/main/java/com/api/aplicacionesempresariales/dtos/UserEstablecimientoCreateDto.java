package com.api.aplicacionesempresariales.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class UserEstablecimientoCreateDto {
    @NotBlank
    private String nombre_establecimiento;

    @NotBlank
    private String direccion_establecimiento;

    @NotBlank
    private String departamento_establecimiento;

    @NotNull
    private LocalTime startTime_establecimiento;

    @NotNull
    private LocalTime endTime_establecimiento;

    @NotBlank
    private String nombre_usuario;

    @NotBlank
    private String apellido_usuario;

    @NotBlank
    private String dni_usuario;

    @NotNull
    private LocalDate fechaNac_usuario;

    private String fotoUrl_usuario;

    @Email
    @NotBlank
    private String correo_usuario;

    @NotBlank
    private String password_usuario;

}
