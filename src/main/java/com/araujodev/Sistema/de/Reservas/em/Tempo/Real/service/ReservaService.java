package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.service;

import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.DTO.ReservaDTO;
import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model.Recurso;
import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model.Usuario;
import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model.Reserva;
import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.repository.RecursoRepository;
import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.repository.ReservaRepository;
import com.araujodev.Sistema.de.Reservas.em.Tempo.Real.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final RecursoRepository recursoRepository;

    // Injeção de dependência via construtor
    public ReservaService(ReservaRepository reservaRepository,
                          UsuarioRepository usuarioRepository,
                          RecursoRepository recursoRepository) {
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.recursoRepository = recursoRepository;
    }

    @Transactional // Garante que toda a operação seja atômica
    public Reserva criarReserva(ReservaDTO request) {
        // 1. Validações de entrada
        if (request.dataInicio().isAfter(request.dataFim())) {
            throw new IllegalArgumentException("A data de início não pode ser posterior à data de fim.");
        }
        if (request.dataInicio().isBefore(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Não é possível criar reservas no passado.");
        }


        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + request.usuarioId()));

        Recurso recurso = recursoRepository.findById(request.recursoId())
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado com ID: " + request.recursoId()));

        if (!recurso.isAtivo()) {
            throw new IllegalStateException("O recurso '" + recurso.getNome() + "' não está ativo para reservas.");
        }


        List<Reserva> sobreposicoes = reservaRepository.findSobreposicaoDeReservas(
                request.recursoId(),
                request.dataInicio(),
                request.dataFim()
        );

        if (!sobreposicoes.isEmpty()) {
            throw new IllegalStateException("O recurso já está reservado neste intervalo de tempo.");
        }


        Reserva novaReserva = new Reserva();
        novaReserva.setUsuario(usuario);
        novaReserva.setRecurso(recurso);
        novaReserva.setDataInicio(request.dataInicio());
        novaReserva.setDataFim(request.dataFim());
        novaReserva.setStatus(Reserva.StatusReserva.ATIVA);

        return reservaRepository.save(novaReserva);
    }
}
