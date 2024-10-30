package br.com.zup.GerenciamentoEmpresaria.services.mappers;

import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.ContratoAtualizacaoDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.ContratoRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Contratos;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;


public class ContratosMapper {


    public static Contratos fromContratoRegistro(ContratoRegistroDTO contratoRegistroDTO, Fornecedor fornecedor) {
        Contratos contratos = new Contratos();
        contratos.setNumeroContrato(contratoRegistroDTO.getNumeroContrato());
        contratos.setDataInicio(contratoRegistroDTO.getDataInicio());
        contratos.setDataTermino(contratoRegistroDTO.getDataTermino());
        contratos.setValorTotal(contratoRegistroDTO.getValorTotal());
        contratos.setDescricao(contratoRegistroDTO.getDescricao());
        contratos.setFornecedor(fornecedor);
        return contratos;
    }

    public static Contratos fromContratoAtualizacao(ContratoAtualizacaoDTO contratoAtualizacaoDTO, Fornecedor fornecedor) {
        Contratos contratos = new Contratos();
        contratos.setId(contratoAtualizacaoDTO.getId());
        contratos.setNumeroContrato(contratoAtualizacaoDTO.getNumeroContrato());
        contratos.setDataInicio(contratoAtualizacaoDTO.getDataInicio());
        contratos.setDataTermino(contratoAtualizacaoDTO.getDataTermino());
        contratos.setValorTotal(contratoAtualizacaoDTO.getValorTotal());
        contratos.setDescricao(contratoAtualizacaoDTO.getDescricao());
        contratos.setFornecedor(fornecedor);

        return contratos;
    }
}