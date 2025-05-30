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
public class Usuario {
    @Id
    @GeneratedValue
    private UUID id;

    private String nombres;
    private String apellidos;
    private String dni;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    private LocalDate fechaNac;
    private String fotoUrl;
    private String correo;
    private String password;
    private String agenda;

    @ManyToOne
    @JoinColumn(name = "establecimiento_id")
    private Establecimiento establecimiento;

    @Column(updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime createdAt;
}
