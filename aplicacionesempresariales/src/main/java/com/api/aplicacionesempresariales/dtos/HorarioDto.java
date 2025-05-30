package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class HorarioDto {
    private UUID id;
    private LocalDate fecha;
    private LocalTime horaStar;
    private int duracion;
    private UsuarioDto funcionario;
}
