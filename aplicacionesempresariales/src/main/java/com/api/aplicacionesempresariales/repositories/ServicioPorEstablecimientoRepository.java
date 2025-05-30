package com.api.aplicacionesempresariales.repositories;

import com.api.aplicacionesempresariales.models.Servicio;
import com.api.aplicacionesempresariales.models.ServicioPorEstablecimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ServicioPorEstablecimientoRepository extends JpaRepository<ServicioPorEstablecimiento, UUID> {

    List<ServicioPorEstablecimiento> findByEstablecimientoId(UUID establecimientoId);

    List<ServicioPorEstablecimiento> findByServicioId(UUID id);

    List<Servicio> getByEstablecimientoId(UUID id);

}
