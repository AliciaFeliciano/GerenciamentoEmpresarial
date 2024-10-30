package br.com.zup.GerenciamentoEmpresaria.controllers.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
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


}