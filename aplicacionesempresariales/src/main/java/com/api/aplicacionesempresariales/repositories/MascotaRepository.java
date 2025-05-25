package com.api.aplicacionesempresariales.repositories;

import com.api.aplicacionesempresariales.models.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, UUID> {

    List<Mascota> findByResponsableId(UUID responsableId);

    Optional<Mascota> findByIdentificacion(String identificacion);
}
