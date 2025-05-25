package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.util.UUID;

@Data
public class ReservaDto {
    private UUID id;
    private String estado;
    private ServicioDto servicio;
    private HorarioDto horario;
    private UsuarioDto usuario;
    private UsuarioDto funcionario;
}
