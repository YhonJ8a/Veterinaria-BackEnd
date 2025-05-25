package com.api.aplicacionesempresariales.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {
    @Id
    @GeneratedValue
    private UUID id;

    private String nombres;
    private String identificacion;
    private LocalDate fechaNac;
    private String fotoUrl;
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "responsable_id")
    private Usuario responsable;
}
