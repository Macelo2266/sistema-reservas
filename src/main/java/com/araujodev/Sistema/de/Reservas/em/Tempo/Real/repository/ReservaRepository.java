package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.repository;

import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("SELECT r FROM Reserva r WHERE r.recurso.id = :recursoId " +
            "AND r.status = 'ATIVA' " +
            "AND r.dataInicio < :fim " +
            "AND r.dataFim > :inicio")
    List<Reserva> findSobreposicaoDeReservas(
            @Param("recursoId") Long recursoId,
            @Param("inicio") OffsetDateTime inicio,
            @Param("fim") OffsetDateTime fim
    );

}
