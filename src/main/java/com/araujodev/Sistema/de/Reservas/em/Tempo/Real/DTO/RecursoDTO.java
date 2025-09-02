package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.DTO;


import jakarta.validation.constraints.NotBlank;

public record RecursoDTO (@NotBlank String nome,
                          String descricao,
                          boolean ativo){

}
