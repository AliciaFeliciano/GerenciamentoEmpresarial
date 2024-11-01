package br.com.zup.GerenciamentoEmpresaria.controllers.contrato.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ContratoAtualizacaoDTO {

    @NotNull(message = "Campo obrigatorio")
    @NotBlank(message = "Campo não pode estar em branco")
    private String id;

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
    @Min(1)
    private String valorTotal;

    @NotNull(message = "Campo obrigatorio")
    @NotBlank(message = "Campo não pode estar em branco")
    private String descricao;

    private boolean ativo;

}
