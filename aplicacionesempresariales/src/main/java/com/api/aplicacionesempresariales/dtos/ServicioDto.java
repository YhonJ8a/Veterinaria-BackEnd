package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.util.UUID;

@Data
public class ServicioDto {
    private UUID id;
    private String nombres;
    private String descripcion;
    private String estado;
    private Double valor;
}
