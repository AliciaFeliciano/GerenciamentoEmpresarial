package br.com.zup.GerenciamentoEmpresaria.services;

import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.zup.GerenciamentoEmpresaria.repositorys.FornecedorRepository;


import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
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

        return fornecedorRepository.save(fornecedorBD);
    }

    public void deletaFornecedor(String id) {
        Fornecedor fornecedor = findFornecedor(id);
        fornecedorRepository.deleteById(fornecedor.getId());
    }
}
