package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class EstablecimientoDto {
    private UUID id;
    private String nombre;
    private String direccion;
    private String departamento;
    private LocalTime startTime;
    private LocalTime endTime;
}
