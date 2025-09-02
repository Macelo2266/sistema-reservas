package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.DTO;

import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model.Recurso;

public record RecursoResponseDTO(Long id,
                                 String nome,
                                 String descricao,
                                 boolean ativo
) {
    public static RecursoResponseDTO fromEntity(Recurso recurso) {
        return new RecursoResponseDTO(
                recurso.getId(),
                recurso.getNome(),
                recurso.getDescricao(),
                recurso.isAtivo()
        );
    }
}
