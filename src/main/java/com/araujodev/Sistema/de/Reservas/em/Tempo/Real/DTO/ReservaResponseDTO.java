package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.DTO;


import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model.Reserva;

import java.time.OffsetDateTime;

public record ReservaResponseDTO(
        Long id,
        Long usuarioId,
        String nomeUsuario,
        Long recursoId,
        String nomeRecurso,
        OffsetDateTime dataInicio,
        OffsetDateTime dataFim,
        String status
) {
    public static ReservaResponseDTO fromEntity(Reserva reserva) {
        return new ReservaResponseDTO(
                reserva.getId(),
                reserva.getUsuario().getId(),
                reserva.getUsuario().getNome(),
                reserva.getRecurso().getId(),
                reserva.getRecurso().getNome(),
                reserva.getDataInicio(),
                reserva.getDataFim(),
                reserva.getStatus().name()
        );
    }
}
