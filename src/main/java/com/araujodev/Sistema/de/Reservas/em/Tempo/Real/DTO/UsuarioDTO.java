package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(@NotBlank String nome,
                         @Email String email,
                         @NotBlank String senha
                        ) {
}
