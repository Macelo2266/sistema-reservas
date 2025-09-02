package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.service;

import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model.Recurso;
import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }
    public Recurso criarRecurso(Recurso recurso) {
        return recursoRepository.save(recurso);
    }

    public List<Recurso> listarRecursos() {
        return recursoRepository.findAll();
    }

    public Recurso buscarPorId(Long id) {
        return recursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado com ID: " + id));
    }
}
