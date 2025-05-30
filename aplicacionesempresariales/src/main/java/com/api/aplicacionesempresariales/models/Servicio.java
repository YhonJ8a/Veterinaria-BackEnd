package com.api.aplicacionesempresariales.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {
    @Id
    @GeneratedValue
    private UUID id;
    private String nombres;
    private String descripcion;
    private String estado;
    private Double valor;
}
