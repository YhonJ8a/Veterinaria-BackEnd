package com.api.aplicacionesempresariales.repositories;

import com.api.aplicacionesempresariales.models.Usuario;
import com.api.aplicacionesempresariales.models.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByCorreo(String correo);

    Optional<Usuario> findByDni(String dni);

    List<Usuario> findByEstablecimientoId(UUID establecimientoId);

    List<Usuario> findByPerfil(Perfil perfil);
}
