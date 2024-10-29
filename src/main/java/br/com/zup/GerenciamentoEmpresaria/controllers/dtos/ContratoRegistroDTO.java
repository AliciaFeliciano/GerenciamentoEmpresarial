package br.com.zup.GerenciamentoEmpresaria.controllers.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ContratoRegistroDTO {

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

    public ContratoRegistroDTO() {}

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
    }

    public @NotNull LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(@NotNull LocalDate dataTermino) {
        this.dataTermino = dataTermino;
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
