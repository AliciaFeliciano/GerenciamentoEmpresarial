package br.com.zup.GerenciamentoEmpresaria.services;

import br.com.zup.GerenciamentoEmpresaria.controllers.models.Contratos;
import br.com.zup.GerenciamentoEmpresaria.repositorys.ContratoRepository;
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

    public List<Contratos> listarContratos() {
        return contratoRepository.findAll();
    }




}
