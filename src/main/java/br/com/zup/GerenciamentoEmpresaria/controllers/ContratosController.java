package br.com.zup.GerenciamentoEmpresaria.controllers;

import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.ContratoAtualizacaoDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.dtos.ContratoRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Fornecedor;
import br.com.zup.GerenciamentoEmpresaria.repositorys.ContratoRepository;
import br.com.zup.GerenciamentoEmpresaria.services.ContratosService;
import br.com.zup.GerenciamentoEmpresaria.controllers.models.Contratos;
import br.com.zup.GerenciamentoEmpresaria.services.mappers.ContratosMapper;
import br.com.zup.GerenciamentoEmpresaria.services.mappers.FornecedorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/contratos")
public class ContratosController {
    @Autowired
    private ContratosService contratosService;
    private ContratoRepository contratoRepository;

    public ContratosController(ContratoRepository contratoRepository, ContratosService contratosService){
        this.contratoRepository = contratoRepository;
        this.contratosService = contratosService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contratos criarContratos(@RequestBody ContratoRegistroDTO contratoRegistroDTO){
        Contratos contratos = ContratosMapper.fromContratoRegistro(contratoRegistroDTO);
        return contratosService.criarContrato(contratos);
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
        Contratos atualizacaocontrato = ContratosMapper.fromContratoAtualizacao(contratoAtualizacaoDTO);
        return contratosService.atualizarContrato(atualizacaocontrato);


    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarContrato(@PathVariable String id) {
        contratosService.deletaContrato(id);
    }

}
