package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.util.UUID;

@Data
public class PerfilDto {
    private UUID id;
    private String perfil;
}
