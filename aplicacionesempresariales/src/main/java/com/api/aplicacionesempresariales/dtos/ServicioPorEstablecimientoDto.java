package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class ServicioPorEstablecimientoDto {
    private UUID id;
    private ServicioDto ServicioId;
    private EstablecimientoDto EstablecimientoId;
}
