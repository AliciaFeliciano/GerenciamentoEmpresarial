package br.com.zup.GerenciamentoEmpresaria.controllers.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
public class FornecedorRegistroDTO {


    @NotNull(message = "Campo obrigadorio")
    @Min(value = 3, message = "O nome dever ter ao menos 3 caracteres ")
    private String nome;

    @NotNull(message = "Campo obrigadorio")
    @CNPJ
    private String cnpj;

    @NotNull(message = "Campo obrigadorio")
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[0-9])[0-9]{3}-[0-9]{4}$", message = "Numero de celular fora do formato")
    private String telefone;

    @NotNull(message = "Campo obrigadorio")
    private String endereco;


    public FornecedorRegistroDTO() {}


}
