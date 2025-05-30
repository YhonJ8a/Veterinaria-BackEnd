package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.util.UUID;

@Data
public class ReservaDto {
    private UUID id;
    private String estado;
    private ServicioPorEstablecimientoDto servicio;
    private HorarioDto horario;
    private MascotaDto mascota;
    private UsuarioDto funcionario;
}
