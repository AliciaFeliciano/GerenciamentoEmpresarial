package br.com.zup.GerenciamentoEmpresaria.services.fornecedores;

import br.com.zup.GerenciamentoEmpresaria.controllers.fornecedores.dtos.FornecedorRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.fornecedores.dtos.FornecedorAtualizacaoDTO;
import br.com.zup.GerenciamentoEmpresaria.models.Fornecedor;
import br.com.zup.GerenciamentoEmpresaria.repositorys.ContratoRepository;
import br.com.zup.GerenciamentoEmpresaria.repositorys.FornecedorRepository;
import br.com.zup.GerenciamentoEmpresaria.services.fornecedores.mapper.FornecedorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository, ContratoRepository contratoRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor criaFornecedor(FornecedorRegistroDTO fornecedorRegistroDTO) {
        return fornecedorRepository.save(FornecedorMapper.fromFornecedorRegistro(fornecedorRegistroDTO));
    }

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor findFornecedor(String id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public Fornecedor atualizacaoFornecedor(FornecedorAtualizacaoDTO fornecedorAtualizacaoDTO) {
        Fornecedor fornecedorBD = findFornecedor(fornecedorAtualizacaoDTO.getId());

        fornecedorBD.setNome(fornecedorAtualizacaoDTO.getNome());
        fornecedorBD.setCnpj(fornecedorAtualizacaoDTO.getCnpj());
        fornecedorBD.setEndereco(fornecedorAtualizacaoDTO.getEndereco());
        fornecedorBD.setTelefone(fornecedorAtualizacaoDTO.getTelefone());

        return fornecedorRepository.save(fornecedorBD);
    }

    public void deletaFornecedor(String id) {
        Fornecedor fornecedor = findFornecedor(id);
        fornecedorRepository.deleteById(fornecedor.getId());
    }
}