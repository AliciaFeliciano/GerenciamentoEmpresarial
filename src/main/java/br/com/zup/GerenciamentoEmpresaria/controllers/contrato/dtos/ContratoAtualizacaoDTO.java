package br.com.zup.GerenciamentoEmpresaria.controllers.contrato.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ContratoAtualizacaoDTO {

    @NotNull(message = "Campo obrigatorio")
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

}
