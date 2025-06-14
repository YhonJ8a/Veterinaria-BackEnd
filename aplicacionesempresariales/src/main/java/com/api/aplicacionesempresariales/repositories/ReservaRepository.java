package com.api.aplicacionesempresariales.repositories;

import com.api.aplicacionesempresariales.models.Horario;
import com.api.aplicacionesempresariales.models.Mascota;
import com.api.aplicacionesempresariales.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, UUID> {

    List<Reserva> findByMascotaId(UUID mascotaId);

    List<Reserva> findByFuncionarioId(UUID funcionarioId);

    List<Reserva> findByEstado(String estado);

    @Query("SELECT r FROM Reserva r WHERE r.horario.fecha BETWEEN :startDate AND :endDate")
    List<Reserva> findByFechaRange(LocalDate startDate, LocalDate endDate);

    boolean existsByHorarioAndMascota(Horario horario, Mascota mascota);

    @Query("SELECT r FROM Reserva r WHERE r.mascota.id = :mascotaId AND r.estado = 'PENDIENTE'")
    List<Reserva> validateRecerva(UUID mascotaId);

    default boolean existsReservaByMascotaAndEstado(UUID mascotaId) {
        return !validateRecerva(mascotaId).isEmpty();
    }

}
