package br.com.zup.GerenciamentoEmpresaria.controllers;

import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.FornecedorAtualizacaoDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.FornecedorRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;
import br.com.zup.GerenciamentoEmpresaria.repositorys.ContratoRepository;
import br.com.zup.GerenciamentoEmpresaria.services.FornecedorService;
import br.com.zup.GerenciamentoEmpresaria.services.mappers.FornecedorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedoresController {

    private final FornecedorService fornecedorService;
    private final ContratoRepository contratoRepository;

    @Autowired
    public FornecedoresController(FornecedorService fornecedorService, ContratoRepository contratoRepository) {
        this.fornecedorService = fornecedorService;
        this.contratoRepository = contratoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor criarFornecedor(@RequestBody FornecedorRegistroDTO fornecedorRegistroDTO) {
        Fornecedor fornecedor = FornecedorMapper.fromFornecedorRegistro(fornecedorRegistroDTO, contratoRepository);
        return fornecedorService.criaFornecedor(fornecedor);
    }

    @GetMapping
    public List<Fornecedor> listFornecedor() {
        return fornecedorService.findAll();
    }

    @GetMapping("/{id}")
    public Fornecedor findFornecedorById(@PathVariable String id) {
        return fornecedorService.findFornecedor(id);
    }

    @PutMapping("/{id}")
    public Fornecedor atualizacaoFornecedor(@PathVariable String id, @RequestBody FornecedorAtualizacaoDTO fornecedorAtualizacaoDTO) {
        fornecedorAtualizacaoDTO.setId(id);
        Fornecedor fornecedor = FornecedorMapper.fromFornecedorAtualizacao(fornecedorAtualizacaoDTO, contratoRepository);
        return fornecedorService.atualizacaoFornecedor(fornecedor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarFornecedor(@PathVariable String id) {
        fornecedorService.deletaFornecedor(id);
    }
}