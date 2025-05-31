package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.util.UUID;

@Data
public class CalificacionSimpleDto {
    private UUID id;
    private String comentario;
    private int estrellas;
}
