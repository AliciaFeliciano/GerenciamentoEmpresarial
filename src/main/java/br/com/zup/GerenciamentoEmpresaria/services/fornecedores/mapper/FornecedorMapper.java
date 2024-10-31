package br.com.zup.GerenciamentoEmpresaria.services.fornecedores.mapper;

import br.com.zup.GerenciamentoEmpresaria.controllers.fornecedores.dtos.FornecedorAtualizacaoDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.fornecedores.FornecedorRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.models.Fornecedor;

public class FornecedorMapper {

    public static Fornecedor fromFornecedorRegistro(FornecedorRegistroDTO fornecedorRegistroDTO) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(fornecedorRegistroDTO.getNome());
        fornecedor.setCnpj(fornecedorRegistroDTO.getCnpj());
        fornecedor.setEndereco(fornecedorRegistroDTO.getEndereco());
        fornecedor.setTelefone(fornecedorRegistroDTO.getTelefone());

        return fornecedor;
    }

    public static Fornecedor fromFornecedorAtualizacao(FornecedorAtualizacaoDTO fornecedorAtualizacaoDTO) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(fornecedorAtualizacaoDTO.getId());
        fornecedor.setNome(fornecedorAtualizacaoDTO.getNome());
        fornecedor.setCnpj(fornecedorAtualizacaoDTO.getCnpj());
        fornecedor.setEndereco(fornecedorAtualizacaoDTO.getEndereco());
        fornecedor.setTelefone(fornecedorAtualizacaoDTO.getTelefone());

        return fornecedor;
    }
}