package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.DTO;


import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record ReservaDTO(
                         @NotNull()
                         Long usuarioId,

                         @NotNull()
                         Long recursoId,

                         @NotNull()
                         OffsetDateTime dataInicio,

                         @NotNull()
                         OffsetDateTime dataFim
) {
}
