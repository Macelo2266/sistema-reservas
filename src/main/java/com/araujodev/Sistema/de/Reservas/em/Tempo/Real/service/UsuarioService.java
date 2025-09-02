package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.service;

import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model.Usuario;
import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));

    }
    public boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

}
