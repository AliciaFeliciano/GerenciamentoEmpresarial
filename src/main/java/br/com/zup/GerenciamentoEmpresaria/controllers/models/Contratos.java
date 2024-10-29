package br.com.zup.GerenciamentoEmpresaria.controllers.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Id;

@Entity
public class Contratos {
    @Id
    @Column(unique = true, nullable = false)
    private String id;

    private String numeroContrato;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private String valorTotal;
    private String descricao;

    @Column(nullable = false)
    private boolean ativo;

    public Contratos() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
        atualizarAtivo();
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
        atualizarAtivo();
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
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

    public void atualizarAtivo() {
        LocalDate hoje = LocalDate.now();
        this.ativo = (dataInicio != null && dataTermino != null) &&
                (hoje.isAfter(dataInicio) || hoje.isEqual(dataInicio)) &&
                (hoje.isBefore(dataTermino) || hoje.isEqual(dataTermino));
    }
}