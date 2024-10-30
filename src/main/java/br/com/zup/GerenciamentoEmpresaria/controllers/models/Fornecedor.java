package br.com.zup.GerenciamentoEmpresaria.controllers.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Fornecedor {

    @Id
    @Column(unique = true, nullable = false)
    private String id;

    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonBackReference
    private List<Contratos> contratos;

    public Fornecedor() {this.id = UUID.randomUUID().toString();}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCnpj() {return cnpj;}

    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public String getEndereco() {return endereco;}

    public void setEndereco(String endereco) {this.endereco = endereco;}

    public String getTelefone() {return telefone;}

    public void setTelefone(String telefone) {this.telefone = telefone;}

    public List<Contratos> getContratos() {return contratos;}

    public void setContratos(List<Contratos> contratos) {this.contratos = contratos;}

}