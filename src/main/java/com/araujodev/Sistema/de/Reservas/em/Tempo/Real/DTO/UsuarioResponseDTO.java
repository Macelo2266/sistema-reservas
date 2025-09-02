package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.DTO;

import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model.Usuario;

public record UsuarioResponseDTO(Long id,
                                 String nome,
                                 String email

) {
    public static UsuarioResponseDTO fromEntity(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}
