package com.api.aplicacionesempresariales.repositories;

import com.api.aplicacionesempresariales.models.Horario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, UUID> {

    List<Horario> findByFuncionarioIdAndFecha(UUID funcionarioId, LocalDate fecha);

    List<Horario> findByFecha(LocalDate fecha);

    @Query("SELECT r FROM Horario r WHERE r.funcionario.id = :id AND r.fecha = :fechaR AND (r.horaStar BETWEEN :startDate AND :endDate OR r.horaEnd BETWEEN :startDate AND :endDate)")
    List<Horario> disponibilidad(UUID id, LocalDate fechaR, LocalTime startDate, LocalTime endDate);
}
