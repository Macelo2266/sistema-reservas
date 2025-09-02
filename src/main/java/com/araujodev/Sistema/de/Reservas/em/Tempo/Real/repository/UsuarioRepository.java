package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.repository;

import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
