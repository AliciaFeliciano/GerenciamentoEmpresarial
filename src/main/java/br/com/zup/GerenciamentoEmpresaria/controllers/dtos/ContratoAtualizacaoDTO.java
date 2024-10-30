package br.com.zup.GerenciamentoEmpresaria.controllers.dtos;

import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class ContratoAtualizacaoDTO {
    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @NotNull(message = "Campo obrigatorio")
    private String numeroContrato;

    @NotNull(message = "Campo obrigatorio")
    private LocalDate dataInicio;

    @NotNull(message = "Campo obrigatorio")
    private LocalDate dataTermino;

    @NotNull(message = "Campo obrigatorio")
    @Min(1)
    private String valorTotal;

    @NotNull(message = "Campo obrigatorio")
    private String descricao;

    @Column(nullable = false)
    private boolean ativo;

    @NotNull(message = "Campo obrigatorio")

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    @JsonManagedReference
    private Fornecedor fornecedor;

    public ContratoAtualizacaoDTO() {this.id = UUID.randomUUID().toString();}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public @NotNull String getNumeroContrato() {return numeroContrato;}

    public void setNumeroContrato(@NotNull String numeroContrato) {this.numeroContrato = numeroContrato;}

    public @NotNull LocalDate getDataInicio() {return dataInicio;}

    public void setDataInicio(@NotNull LocalDate dataInicio) {
        this.dataInicio = dataInicio;
        atualizarAtivo();
    }

    public @NotNull LocalDate getDataTermino() {return dataTermino;}

    public void setDataTermino(@NotNull LocalDate dataTermino) {
        this.dataTermino = dataTermino;
        atualizarAtivo();
    }

    public @NotNull @Min(1) String getValorTotal() {return valorTotal;}

    public void setValorTotal(@NotNull @Min(1) String valorTotal) {this.valorTotal = valorTotal;}

    public @NotNull String getDescricao() {return descricao;}

    public void setDescricao(@NotNull String descricao) {this.descricao = descricao;}

    public boolean isAtivo() {return ativo;}

    public void atualizarAtivo() {
        LocalDate hoje = LocalDate.now();
        this.ativo = (dataInicio != null && dataTermino != null) &&
                (hoje.isAfter(dataInicio) || hoje.isEqual(dataInicio)) &&
                (hoje.isBefore(dataTermino) || hoje.isEqual(dataTermino));
    }

    public Fornecedor getFornecedor() {return fornecedor;}

    public void setFornecedor(Fornecedor fornecedor) {this.fornecedor = fornecedor;}
}
