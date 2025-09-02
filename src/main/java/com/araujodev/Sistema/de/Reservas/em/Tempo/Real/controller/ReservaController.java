package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.controller;

import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.DTO.ReservaDTO;
import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.DTO.ReservaResponseDTO;
import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model.Reserva;
import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> criarNovaReserva(@RequestBody ReservaDTO request) {
        try {
            Reserva novaReserva = reservaService.criarReserva(request);
            ReservaResponseDTO response = ReservaResponseDTO.fromEntity(novaReserva);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IllegalArgumentException | IllegalStateException e) {
            // Tratamento de exceções de negócio
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Em um app real, retornar um DTO de erro com a mensagem de e.getMessage()
        } catch (RuntimeException e) {
            // Tratamento de exceções inesperadas (ex: recurso não encontrado)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retornar DTO de erro
        }
    }
}
