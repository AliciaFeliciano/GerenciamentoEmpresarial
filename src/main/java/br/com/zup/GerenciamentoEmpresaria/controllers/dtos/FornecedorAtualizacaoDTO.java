package br.com.zup.GerenciamentoEmpresaria.controllers.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;
import java.util.UUID;

public class FornecedorAtualizacaoDTO {

    @Id
    @Column(columnDefinition = "UUID" ,unique = true, nullable = false)
    private String id;

    @NotNull(message = "Campo obrigadorio")
    @Min(value = 3, message = "O nome dever ter ao menos 3 caracteres ")
    private String nome;

    @NotNull(message = "Campo obrigadorio")
    @CNPJ
    private String cnpj;

    @NotNull(message = "Campo obrigadorio")
    private String endereco;

    @NotNull(message = "Campo obrigadorio")
    @Min(10)
    @Max(11)
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Formato de telefone inválido. O formato esperado é (XX) XXXXX-XXXX.")
    private String telefone;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    private List<String> contratos;

    public FornecedorAtualizacaoDTO() {this.id = UUID.randomUUID().toString();}

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

    public List<String> getContratos() {return contratos;}

    public void setContratos(List<String> contratos) {this.contratos = contratos;}

}
