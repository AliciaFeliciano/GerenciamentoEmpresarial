package br.com.zup.GerenciamentoEmpresaria.controllers.dtos;

import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
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

    private boolean ativo;

    @NotNull(message = "Campo obrigatorio")

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    @JsonManagedReference
    private Fornecedor fornecedor;

    public ContratoAtualizacaoDTO() {this.id = UUID.randomUUID().toString();}

}
