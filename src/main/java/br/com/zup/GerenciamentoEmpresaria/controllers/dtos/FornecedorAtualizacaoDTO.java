package br.com.zup.GerenciamentoEmpresaria.controllers.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class FornecedorAtualizacaoDTO {

    @Id
    @Column(columnDefinition = "UUID" ,unique = true, nullable = false)
    private String id;

    @NotNull
    @Min(3)
    private String nome;

    @NotNull
    private String cnpj;

    @NotNull
    private String endereco;

    @NotNull
    @Min(11)
    @Max(11)
    private String telefone;

    public FornecedorAtualizacaoDTO() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotNull @Min(3) String getNome() {
        return nome;
    }

    public void setNome(@NotNull @Min(3) String nome) {
        this.nome = nome;
    }

    public @NotNull String getCnpj() {return cnpj;}

    public void setCnpj(@NotNull String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull String endereco) {
        this.endereco = endereco;
    }

    public @NotNull @Min(11) @Max(11) String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull @Min(11) @Max(11) String telefone) {
        this.telefone = telefone;
    }

}
