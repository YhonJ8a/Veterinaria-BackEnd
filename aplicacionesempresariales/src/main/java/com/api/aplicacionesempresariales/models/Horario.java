package com.api.aplicacionesempresariales.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    @Id
    @GeneratedValue
    private UUID id;

    private LocalDate fecha;
    private LocalTime horaStar;
    private LocalTime horaEnd;
    private int duracion;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Usuario funcionario;
}
