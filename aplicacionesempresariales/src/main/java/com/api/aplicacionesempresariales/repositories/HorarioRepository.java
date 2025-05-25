package com.api.aplicacionesempresariales.repositories;

import com.api.aplicacionesempresariales.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, UUID> {

    List<Horario> findByFuncionarioIdAndFecha(UUID funcionarioId, LocalDate fecha);

    List<Horario> findByFecha(LocalDate fecha);
}
