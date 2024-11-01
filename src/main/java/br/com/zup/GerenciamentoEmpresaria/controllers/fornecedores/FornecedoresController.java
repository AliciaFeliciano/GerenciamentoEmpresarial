package br.com.zup.GerenciamentoEmpresaria.controllers.fornecedores;

import br.com.zup.GerenciamentoEmpresaria.controllers.fornecedores.dtos.FornecedorAtualizacaoDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.fornecedores.dtos.FornecedorRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.models.Fornecedor;
import br.com.zup.GerenciamentoEmpresaria.services.fornecedores.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedoresController {

    @Autowired
    private final FornecedorService fornecedorService;



    public FornecedoresController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor criarFornecedor(@Valid @RequestBody FornecedorRegistroDTO fornecedorRegistroDTO) {
        return fornecedorService.criaFornecedor(fornecedorRegistroDTO);
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
    public Fornecedor atualizacaoFornecedor(@Valid @PathVariable String id, @RequestBody FornecedorAtualizacaoDTO fornecedorAtualizacaoDTO) {
        fornecedorAtualizacaoDTO.setId(id);
        return fornecedorService.atualizacaoFornecedor(fornecedorAtualizacaoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarFornecedor(@PathVariable String id){
        fornecedorService.deletaFornecedor(id);
    }
}