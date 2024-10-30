package br.com.zup.GerenciamentoEmpresaria.services.mappers;

import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.FornecedorAtualizacaoDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.FornecedorRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;
import br.com.zup.GerenciamentoEmpresaria.repositorys.ContratoRepository;

public class FornecedorMapper {

    public static Fornecedor fromFornecedorRegistro(FornecedorRegistroDTO fornecedorRegistroDTO, ContratoRepository contratoRepository) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(fornecedorRegistroDTO.getNome());
        fornecedor.setCnpj(fornecedorRegistroDTO.getCnpj());
        fornecedor.setEndereco(fornecedorRegistroDTO.getEndereco());
        fornecedor.setTelefone(fornecedorRegistroDTO.getTelefone());

        return fornecedor;
    }

    public static Fornecedor fromFornecedorAtualizacao(FornecedorAtualizacaoDTO fornecedorAtualizacaoDTO, ContratoRepository contratoRepository) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(fornecedorAtualizacaoDTO.getId());
        fornecedor.setNome(fornecedorAtualizacaoDTO.getNome());
        fornecedor.setCnpj(fornecedorAtualizacaoDTO.getCnpj());
        fornecedor.setEndereco(fornecedorAtualizacaoDTO.getEndereco());
        fornecedor.setTelefone(fornecedorAtualizacaoDTO.getTelefone());

        return fornecedor;
    }
}