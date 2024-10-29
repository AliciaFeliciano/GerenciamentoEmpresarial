package br.com.zup.GerenciamentoEmpresaria.controllers.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class ContratoAtualizacaoDTO {
    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @NotNull
    private String numeroContrato;
    @NotNull
    private LocalDate dataInicio;
    @NotNull
    private LocalDate dataTermino;
    @NotNull
    @Min(1)
    private String valorTotal;
    @NotNull
    private String descricao;

    @Column(nullable = false)
    private boolean ativo;

    public ContratoAtualizacaoDTO() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotNull String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(@NotNull String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public @NotNull LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(@NotNull LocalDate dataInicio) {
        this.dataInicio = dataInicio;
        atualizarAtivo();
    }

    public @NotNull LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(@NotNull LocalDate dataTermino) {
        this.dataTermino = dataTermino;
        atualizarAtivo();
    }

    public @NotNull @Min(1) String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(@NotNull @Min(1) String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public @NotNull String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull String descricao) {
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
