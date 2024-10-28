package br.com.zup.GerenciamentoEmpresaria.controllers.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

public class FornecedorRegistroDTO {

    @NotNull
    @Min(3)
    private String nome;

    @NotNull
    @CNPJ
    private String CNPJ;

    @NotNull
    private String endereco;

    @NotNull
    @Min(11)
    @Max(11)
    private String telefone;

    public FornecedorRegistroDTO() {}

    public @NotNull @Min(3) String getNome() {
        return nome;
    }

    public void setNome(@NotNull @Min(3) String nome) {
        this.nome = nome;
    }

    public @NotNull @org.hibernate.validator.constraints.br.CNPJ String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(@NotNull @org.hibernate.validator.constraints.br.CNPJ String CNPJ) {
        this.CNPJ = CNPJ;
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
