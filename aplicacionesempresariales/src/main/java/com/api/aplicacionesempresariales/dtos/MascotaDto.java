package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MascotaDto {
    private UUID id;
    private String nombres;
    private String identificacion;
    private LocalDate fechaNac;
    private String fotoUrl;
    private LocalDateTime createdAt;
    private UsuarioDto responsable;
}
