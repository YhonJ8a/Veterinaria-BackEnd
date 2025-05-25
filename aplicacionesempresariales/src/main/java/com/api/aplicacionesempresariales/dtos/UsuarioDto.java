package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UsuarioDto {
    private UUID id;
    private String nombres;
    private String apellidos;
    private String dni;
    private PerfilDto perfil;
    private LocalDate fechaNac;
    private String fotoUrl;
    private String correo;
    private String agenda;
    private LocalDateTime createdAt;
    private EstablecimientoDto establecimiento;
}
