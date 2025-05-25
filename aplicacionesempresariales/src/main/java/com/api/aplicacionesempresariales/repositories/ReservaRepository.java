package com.api.aplicacionesempresariales.repositories;

import com.api.aplicacionesempresariales.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, UUID> {

    List<Reserva> findByUsuarioId(UUID usuarioId);

    List<Reserva> findByFuncionarioId(UUID funcionarioId);

    List<Reserva> findByEstado(String estado);

    @Query("SELECT r FROM Reserva r WHERE r.horario.fecha BETWEEN :startDate AND :endDate")
    List<Reserva> findByFechaRange(LocalDate startDate, LocalDate endDate);
}
