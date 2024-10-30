package br.com.zup.GerenciamentoEmpresaria.services;

import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;
import br.com.zup.GerenciamentoEmpresaria.repositorys.ContratoRepository;
import br.com.zup.GerenciamentoEmpresaria.repositorys.FornecedorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final ContratoRepository contratoRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository, ContratoRepository contratoRepository) {
        this.fornecedorRepository = fornecedorRepository;
        this.contratoRepository = contratoRepository;
    }

    public ContratoRepository getContratoRepository() {
        return contratoRepository;
    }


    public Fornecedor criaFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor findFornecedor(String id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado"));
    }

    public Fornecedor atualizacaoFornecedor(Fornecedor fornecedor) {
        Fornecedor fornecedorBD = findFornecedor(fornecedor.getId());

        fornecedorBD.setNome(fornecedor.getNome());
        fornecedorBD.setCnpj(fornecedor.getCnpj());
        fornecedorBD.setEndereco(fornecedor.getEndereco());
        fornecedorBD.setTelefone(fornecedor.getTelefone());
        fornecedorBD.setContratos(fornecedor.getContratos());

        return fornecedorRepository.save(fornecedorBD);
    }

    public void deletaFornecedor(String id) {
        Fornecedor fornecedor = findFornecedor(id);
        fornecedorRepository.deleteById(fornecedor.getId());
    }
}