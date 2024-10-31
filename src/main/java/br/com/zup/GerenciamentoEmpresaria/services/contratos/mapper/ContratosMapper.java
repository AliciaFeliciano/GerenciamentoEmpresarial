package br.com.zup.GerenciamentoEmpresaria.services.contratos.mapper;

import br.com.zup.GerenciamentoEmpresaria.controllers.contrato.dtos.ContratoAtualizacaoDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.contrato.dtos.ContratoRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.models.Contratos;


public class ContratosMapper {


    public static Contratos fromContratoRegistro(ContratoRegistroDTO contratoRegistroDTO) {
        Contratos contratos = new Contratos();
        contratos.setNumeroContrato(contratoRegistroDTO.getNumeroContrato());
        contratos.setDataInicio(contratoRegistroDTO.getDataInicio());
        contratos.setDataTermino(contratoRegistroDTO.getDataTermino());
        contratos.setValorTotal(contratoRegistroDTO.getValorTotal());
        contratos.setDescricao(contratoRegistroDTO.getDescricao());
        return contratos;
    }

    public static void  fromContratoAtualizacao(ContratoAtualizacaoDTO contratoAtualizacaoDTO) {
        Contratos contratos = new Contratos();
        contratos.setId(contratoAtualizacaoDTO.getId());
        contratos.setNumeroContrato(contratoAtualizacaoDTO.getNumeroContrato());
        contratos.setDataInicio(contratoAtualizacaoDTO.getDataInicio());
        contratos.setDataTermino(contratoAtualizacaoDTO.getDataTermino());
        contratos.setValorTotal(contratoAtualizacaoDTO.getValorTotal());
        contratos.setDescricao(contratoAtualizacaoDTO.getDescricao());
        contratos.setAtivo(contratoAtualizacaoDTO.isAtivo());
    }
}