package com.api.aplicacionesempresariales.repositories;

import com.api.aplicacionesempresariales.models.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, UUID> {

    Optional<Calificacion> findByReservaId(UUID reservaId);
}
