package br.com.zup.GerenciamentoEmpresaria.controllers.contrato.dtos;

import br.com.zup.GerenciamentoEmpresaria.models.Fornecedor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class ContratoRegistroDTO {

    @NotNull(message = "Campo obrigatorio")
    @NotBlank(message = "Campo não pode estar em branco")
    private String numeroContrato;

    @NotNull(message = "Campo obrigatorio")
    @NotBlank(message = "Campo não pode estar em branco")
    private LocalDate dataInicio;

    @NotNull(message = "Campo obrigatorio")
    @NotBlank(message = "Campo não pode estar em branco")
    private LocalDate dataTermino;

    @NotNull(message = "Campo obrigatorio")
    @NotBlank(message = "Campo não pode estar em branco")
    @Min(value = 1, message = "O valor dever ser maior que zero")
    private String valorTotal;

    @NotNull(message = "Campo obrigatorio")
    @NotBlank(message = "Campo não pode estar em branco")
    private String descricao;

    private boolean ativo;

    @NotNull(message = "Campo obrigatorio")
    @NotBlank(message = "Campo não pode estar em branco")
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    public ContratoRegistroDTO() {}


}
