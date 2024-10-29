package br.com.zup.GerenciamentoEmpresaria.services;

import br.com.zup.GerenciamentoEmpresaria.controllers.models.Contratos;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;
import br.com.zup.GerenciamentoEmpresaria.repositorys.ContratoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratosService {

    @Autowired
    private ContratoRepository contratoRepository;

    public ContratosService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public Contratos criarContrato(Contratos contratos) {
        return contratoRepository.save(contratos);
    }


    public List<Contratos> findAll() {
        return contratoRepository.findAll();
    }


    public Contratos findContrato(String id) {
        return contratoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrato não encontrado"));
    }

    public Contratos atualizarContrato(Contratos contratos) {
        Contratos contratosBD = findContrato(contratos.getId());

        contratosBD.setNumeroContrato(contratos.getNumeroContrato());
        contratosBD.setDataTermino(contratos.getDataTermino());
        contratosBD.setDataInicio(contratos.getDataInicio());
        contratosBD.setDescricao(contratos.getDescricao());
        contratosBD.setId(contratos.getId());

        return contratoRepository.save(contratosBD);
    }

    public void deletaContrato(String id) {
        Contratos contrato = findContrato(id);
        contratoRepository.deleteById(contrato.getId());
    }

}
