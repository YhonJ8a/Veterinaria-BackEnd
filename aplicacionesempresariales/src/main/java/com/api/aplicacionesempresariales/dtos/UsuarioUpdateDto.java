package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class UsuarioUpdateDto {
    private String nombres;
    private String apellidos;
    private String dni;
    private UUID perfilId;
    private LocalDate fechaNac;
    private String fotoUrl;
    private String correo;
    private String password;
    private String agenda;
    private UUID establecimientoId;
}
