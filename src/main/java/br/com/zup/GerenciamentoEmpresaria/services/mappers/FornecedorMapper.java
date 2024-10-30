package br.com.zup.GerenciamentoEmpresaria.services.mappers;

import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.FornecedorAtualizacaoDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.FornecedorRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Contratos;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;
import br.com.zup.GerenciamentoEmpresaria.repositorys.ContratoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FornecedorMapper {

    public static Fornecedor fromFornecedorRegistro(FornecedorRegistroDTO fornecedorRegistroDTO, ContratoRepository contratoRepository) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(fornecedorRegistroDTO.getNome());
        fornecedor.setCnpj(fornecedorRegistroDTO.getCnpj());
        fornecedor.setEndereco(fornecedorRegistroDTO.getEndereco());
        fornecedor.setTelefone(fornecedorRegistroDTO.getTelefone());

        List<Contratos> contratos = fornecedorRegistroDTO.getContratos().stream()
                .map(contratoId -> contratoRepository.findById(contratoId)
                        .orElseThrow(() -> new RuntimeException("Contrato não encontrado")))
                .collect(Collectors.toList());

        fornecedor.setContratos(contratos);

        return fornecedor;
    }

    public static Fornecedor fromFornecedorAtualizacao(FornecedorAtualizacaoDTO fornecedorAtualizacaoDTO, ContratoRepository contratoRepository) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(fornecedorAtualizacaoDTO.getId());
        fornecedor.setNome(fornecedorAtualizacaoDTO.getNome());
        fornecedor.setCnpj(fornecedorAtualizacaoDTO.getCnpj());
        fornecedor.setEndereco(fornecedorAtualizacaoDTO.getEndereco());
        fornecedor.setTelefone(fornecedorAtualizacaoDTO.getTelefone());

        List<Contratos> contratos = fornecedorAtualizacaoDTO.getContratos().stream()
                .map(contratoId -> contratoRepository.findById(contratoId)
                        .orElseThrow(() -> new RuntimeException("Contrato não encontrado")))
                .collect(Collectors.toList());

        fornecedor.setContratos(contratos);

        return fornecedor;
    }
}