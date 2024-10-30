package br.com.zup.GerenciamentoEmpresaria.services;

import br.com.zup.GerenciamentoEmpresaria.controllers.models.Contratos;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;
import br.com.zup.GerenciamentoEmpresaria.repositorys.ContratoRepository;
import br.com.zup.GerenciamentoEmpresaria.repositorys.FornecedorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContratosService {

    @Autowired
    private ContratoRepository contratoRepository;
    private FornecedorRepository fornecedorRepository;


    public ContratosService(ContratoRepository contratoRepository, FornecedorRepository fornecedorRepository) {
        this.contratoRepository = contratoRepository;
        this.fornecedorRepository = fornecedorRepository;
    }

    public void validarDatas(LocalDate dataInicio, LocalDate dataTermino) {
        if (dataInicio != null && dataTermino != null && dataTermino.isBefore(dataInicio)) {
            throw new IllegalArgumentException("A data de término deve ser maior que a data de início.");
        }
    }

    public boolean atualizarAtivo(LocalDate dataInicio, LocalDate dataTermino) {
        LocalDate hoje = LocalDate.now();
        return (dataInicio != null && dataTermino != null) &&
                (hoje.isAfter(dataInicio) || hoje.isEqual(dataInicio)) &&
                (hoje.isBefore(dataTermino) || hoje.isEqual(dataTermino));
    }

    public Contratos criarContrato(Contratos contratos,String fornecedorId) {
        Fornecedor fornecedor = fornecedorRepository.findById(fornecedorId)
                .orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado"));
        contratos.setFornecedor(fornecedor);
        return contratoRepository.save(contratos);
    }


    public List<Contratos> findAll() {
        return contratoRepository.findAll();
    }


    public Contratos findContrato(String id) {
        return contratoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrato não encontrado"));
    }

    public Contratos atualizarContrato(Contratos contratos, String fornecedorId) {
        Contratos contratosBD = findContrato(contratos.getId());
        Fornecedor fornecedor = fornecedorRepository.findById(fornecedorId)
                .orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado"));

        contratosBD.setNumeroContrato(contratos.getNumeroContrato());
        contratosBD.setDataTermino(contratos.getDataTermino());
        contratosBD.setDataInicio(contratos.getDataInicio());
        contratosBD.setDescricao(contratos.getDescricao());
        contratosBD.setId(contratos.getId());
        contratosBD.setFornecedor(fornecedor);

        return contratoRepository.save(contratosBD);
    }

    public void deletaContrato(String id) {
        Contratos contrato = findContrato(id);
        contratoRepository.deleteById(contrato.getId());
    }

}