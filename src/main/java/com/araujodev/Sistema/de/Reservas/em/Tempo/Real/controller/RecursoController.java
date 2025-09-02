package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.controller;

import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model.Recurso;
import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.service.RecursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @PostMapping
    public ResponseEntity<Recurso> criarRecurso(@RequestBody Recurso recurso) {
        Recurso novoRecurso = recursoService.criarRecurso(recurso);
        return new ResponseEntity<>(novoRecurso, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Recurso>> listarRecursos() {
        return new ResponseEntity<>(recursoService.listarRecursos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recurso> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(recursoService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
