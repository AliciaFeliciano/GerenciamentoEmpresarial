package br.com.zup.GerenciamentoEmpresaria.controllers.dtos;

import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class ContratoRegistroDTO {

    @NotNull(message = "Campo obrigatorio")
    private String numeroContrato;

    @NotNull(message = "Campo obrigatorio")
    private LocalDate dataInicio;

    @NotNull(message = "Campo obrigatorio")
    private LocalDate dataTermino;

    @NotNull(message = "Campo obrigatorio")
    @Min(value = 1, message = "O valor dever ser maior que zero")
    private String valorTotal;

    @NotNull(message = "Campo obrigatorio")
    private String descricao;

    private boolean ativo;

    @NotNull(message = "Campo obrigatorio")
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    public ContratoRegistroDTO() {}


}
