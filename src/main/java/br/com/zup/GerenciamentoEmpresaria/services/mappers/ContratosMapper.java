package br.com.zup.GerenciamentoEmpresaria.services.mappers;

import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.ContratoRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Contratos;

public class ContratosMapper {

    public static Contratos fromContratoRegistro (ContratoRegistroDTO contratoRegistroDTO){
        Contratos contratos = new Contratos();
        contratos.setNumeroContrato(contratoRegistroDTO.getNumeroContrato());
        contratos.setDataInicio(contratoRegistroDTO.getDataInicio());
        contratos.setDataTermino(contratoRegistroDTO.getDataTermino());
        contratos.setValorTotal(contratoRegistroDTO.getValorTotal());
        contratos.setDescricao(contratoRegistroDTO.getDescricao());

        return contratos;

    }
}
