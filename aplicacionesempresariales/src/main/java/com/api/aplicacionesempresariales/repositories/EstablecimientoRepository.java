package com.api.aplicacionesempresariales.repositories;

import com.api.aplicacionesempresariales.models.Establecimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstablecimientoRepository extends JpaRepository<Establecimiento, UUID> {
}
