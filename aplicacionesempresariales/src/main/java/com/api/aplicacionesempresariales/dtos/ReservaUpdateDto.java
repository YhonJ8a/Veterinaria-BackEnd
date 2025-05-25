package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.util.UUID;

@Data
public class ReservaUpdateDto {
    private String estado;
    private UUID horarioId;
    private UUID funcionarioId;
}
