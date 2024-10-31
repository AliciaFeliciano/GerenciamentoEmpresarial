package br.com.zup.GerenciamentoEmpresaria.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Contratos {
    @Id
    @Column(unique = true, nullable = false)
    private String id;

    private String numeroContrato;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private String valorTotal;
    private String descricao;
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    @JsonIgnore
    private Fornecedor fornecedor;

    public Contratos() {this.id = UUID.randomUUID().toString();}

}