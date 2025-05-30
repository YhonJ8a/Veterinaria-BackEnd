package com.api.aplicacionesempresariales.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue
    private UUID id;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private ServicioPorEstablecimiento servicio;

    @ManyToOne
    @JoinColumn(name = "horario_id")
    private Horario horario;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario funcionario;
}
