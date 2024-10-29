package br.com.zup.GerenciamentoEmpresaria.controllers.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class FornecedorRegistroDTO {

    @NotNull
    @Min(3)
    private String nome;

    @NotNull
    private String cnpj;

    @NotNull
    private String telefone;


    @NotNull
    private String endereco;


    public FornecedorRegistroDTO() {}

    public @NotNull @Min(3) String getNome() {
        return nome;
    }

    public void setNome(@NotNull @Min(3) String nome) {
        this.nome = nome;
    }

    public @NotNull  String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull  String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull  String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull  String telefone) {
        this.telefone = telefone;
    }

    public @NotNull String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull String endereco) {
        this.endereco = endereco;
    }

}
