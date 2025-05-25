package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class MascotaUpdateDto {
    private String nombres;
    private String identificacion;
    private LocalDate fechaNac;
    private String fotoUrl;
    private UUID responsableId;
}
