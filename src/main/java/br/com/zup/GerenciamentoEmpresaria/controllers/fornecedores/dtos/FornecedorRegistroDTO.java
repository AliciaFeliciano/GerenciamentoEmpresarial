package br.com.zup.GerenciamentoEmpresaria.controllers.fornecedores.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
public class FornecedorRegistroDTO {


    @NotNull(message = "Campo obrigadorio")
    @NotBlank(message = "Campo não pode estar em branco")
    @Min(value = 3, message = "O nome dever ter ao menos 3 caracteres ")
    private String nome;

    @NotNull(message = "Campo obrigadorio")
    @NotBlank(message = "Campo não pode estar em branco")
    @CNPJ(message = "O cnpj deve estar no padrão brasileiro")
    private String cnpj;

    @NotNull(message = "Campo obrigadorio")
    @NotBlank(message = "Campo não pode estar em branco")
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[0-9])[0-9]{3}-[0-9]{4}$", message = "Numero de celular fora do formato")
    private String telefone;

    @NotNull(message = "Campo obrigadorio")
    @NotBlank(message = "Campo não pode estar em branco")
    private String endereco;


    public FornecedorRegistroDTO() {}

}
