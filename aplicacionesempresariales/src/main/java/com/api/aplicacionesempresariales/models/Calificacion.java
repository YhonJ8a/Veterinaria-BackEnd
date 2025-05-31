package com.api.aplicacionesempresariales.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calificacion {
    @Id
    @GeneratedValue
    private UUID id;

    private String comentario;

    private int estrellas;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
}
