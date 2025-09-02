package com.araujodev.Sistema.de.Reservas.em.Tempo.Real.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recursos")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private boolean ativo;

    @OneToMany(mappedBy = "recurso", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<Reserva>();

    public Recurso() {

    }
   public Recurso(String nome, String descricao, boolean ativo) {
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
