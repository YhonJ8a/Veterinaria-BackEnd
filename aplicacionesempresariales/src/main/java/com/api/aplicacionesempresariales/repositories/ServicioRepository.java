package com.api.aplicacionesempresariales.repositories;

import com.api.aplicacionesempresariales.models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, UUID> {
}
