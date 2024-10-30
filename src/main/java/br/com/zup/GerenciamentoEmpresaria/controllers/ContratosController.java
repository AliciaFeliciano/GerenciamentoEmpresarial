package br.com.zup.GerenciamentoEmpresaria.controllers;

import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.ContratoAtualizacaoDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.ContratoRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;
import br.com.zup.GerenciamentoEmpresaria.services.ContratosService;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Contratos;
import br.com.zup.GerenciamentoEmpresaria.services.FornecedorService;
import br.com.zup.GerenciamentoEmpresaria.services.mappers.ContratosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/contratos")
public class ContratosController {
    @Autowired
    private ContratosService contratosService;
    private FornecedorService fornecedorService;

    public ContratosController(ContratosService contratosService, FornecedorService fornecedorService) {
        this.contratosService = contratosService;
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contratos criarContratos(@RequestBody ContratoRegistroDTO contratoRegistroDTO){
        Fornecedor fornecedor = fornecedorService.findFornecedor(contratoRegistroDTO.getFornecedor().getId());
        Contratos contratos = ContratosMapper.fromContratoRegistro(contratoRegistroDTO, fornecedor);
        return contratosService.criarContrato(contratos, fornecedor.getId());

    }

    @GetMapping
    public List<Contratos> listContratos(){
        return contratosService.findAll();
    }

    @GetMapping("/{id}")
    public Contratos findContratosById(@PathVariable String id) {
        return contratosService.findContrato(id);
    }

    @PutMapping("/{id}")
    public Contratos atualizarContratos(@PathVariable String id,@RequestBody ContratoAtualizacaoDTO contratoAtualizacaoDTO) {
        contratoAtualizacaoDTO.setId(id);
        Fornecedor fornecedor = fornecedorService.findFornecedor(contratoAtualizacaoDTO.getFornecedor().getId());
        Contratos atualizacaocontrato = ContratosMapper.fromContratoAtualizacao(contratoAtualizacaoDTO, fornecedor);
        return contratosService.atualizarContrato(atualizacaocontrato, fornecedor.getId());

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarContrato(@PathVariable String id) {
        contratosService.deletaContrato(id);
    }

}
