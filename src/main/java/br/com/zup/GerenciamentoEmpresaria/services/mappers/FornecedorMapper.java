package br.com.zup.GerenciamentoEmpresaria.services.mappers;

import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.FornecedorAtualizacaoDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.FornecedorRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;

public class FornecedorMapper {

    public static Fornecedor fromFornecedorRegistro(FornecedorRegistroDTO fornecedorRegistroDTO) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedorRegistroDTO.setNome(fornecedorRegistroDTO.getNome());
        fornecedorRegistroDTO.setCNPJ(fornecedorRegistroDTO.getCNPJ());
        fornecedorRegistroDTO.setEndereco(fornecedorRegistroDTO.getEndereco());
        fornecedorRegistroDTO.setTelefone(fornecedorRegistroDTO.getTelefone());

        return fornecedor;
    }

    public static Fornecedor fromFornecedorAtualizacao(FornecedorAtualizacaoDTO fornecedorAtualizacaoDTO) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedorAtualizacaoDTO.setId(fornecedorAtualizacaoDTO.getId());
        fornecedorAtualizacaoDTO.setNome(fornecedorAtualizacaoDTO.getNome());
        fornecedorAtualizacaoDTO.setCNPJ(fornecedorAtualizacaoDTO.getCNPJ());
        fornecedorAtualizacaoDTO.setEndereco(fornecedorAtualizacaoDTO.getEndereco());
        fornecedorAtualizacaoDTO.setTelefone(fornecedorAtualizacaoDTO.getTelefone());

        return fornecedor;
    }
}
