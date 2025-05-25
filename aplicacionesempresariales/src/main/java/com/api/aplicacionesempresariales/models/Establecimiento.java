package com.api.aplicacionesempresariales.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Establecimiento {
    @Id
    @GeneratedValue
    private UUID id;

    private String nombre;
    private String direccion;
    private String departamento;
    private LocalTime startTime;
    private LocalTime endTime;
}
