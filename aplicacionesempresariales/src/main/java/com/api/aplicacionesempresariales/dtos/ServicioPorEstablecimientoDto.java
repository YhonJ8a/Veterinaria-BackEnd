package com.api.aplicacionesempresariales.dtos;

import lombok.Data;
import java.util.UUID;

@Data
public class ServicioPorEstablecimientoDto {
    private UUID id;
    private ServicioDto Servicio;
    private EstablecimientoDto Establecimiento;
}
