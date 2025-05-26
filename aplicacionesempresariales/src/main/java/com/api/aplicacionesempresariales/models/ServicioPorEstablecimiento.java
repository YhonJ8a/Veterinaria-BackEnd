package com.api.aplicacionesempresariales.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicioPorEstablecimiento {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @JoinColumn(name = "establecimiento_id")
    private Establecimiento establecimiento;

    @OneToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;
}
