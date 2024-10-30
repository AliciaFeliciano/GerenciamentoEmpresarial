package br.com.zup.GerenciamentoEmpresaria.controllers.dtos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

public class FornecedorRegistroDTO {

    @NotNull(message = "Campo obrigadorio")
    @Min(value = 3, message = "O nome dever ter ao menos 3 caracteres ")
    private String nome;

    @NotNull(message = "Campo obrigadorio")
    @CNPJ
    private String cnpj;

    @NotNull(message = "Campo obrigadorio")
    @Min(10)
    @Max(11)
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Formato de telefone inválido. O formato esperado é (XX) XXXXX-XXXX.")
    private String telefone;

    @NotNull(message = "Campo obrigadorio")
    private String endereco;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    private List<String> contratos;

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

    public List<String> getContratos() {return contratos;}

    public void setContratos(List<String> contratos) {this.contratos = contratos;}

}
