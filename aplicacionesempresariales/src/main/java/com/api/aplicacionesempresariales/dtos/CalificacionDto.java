package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.util.UUID;

@Data
public class CalificacionDto {
    private UUID id;
    private String comentario;
    private ReservaDto reserva;
}
