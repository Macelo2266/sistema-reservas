package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.repository;

import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {
}
