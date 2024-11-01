package br.com.zup.GerenciamentoEmpresaria.controllers.contrato;

import br.com.zup.GerenciamentoEmpresaria.controllers.contrato.dtos.ContratoAtualizacaoDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.contrato.dtos.ContratoRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.repositorys.ContratoRepository;
import br.com.zup.GerenciamentoEmpresaria.services.contratos.ContratosService;
import br.com.zup.GerenciamentoEmpresaria.models.Contratos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping( "/fornecedores/{fornecedor_id}/contratos")
public class ContratosController {

    @Autowired
    private ContratosService contratosService;


    public ContratosController(ContratosService contratosService,ContratoRepository contratoRepository) {
        this.contratosService = contratosService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contratos criarContratos(@PathVariable String fornecedor_id, @RequestBody ContratoRegistroDTO contratoRegistroDTO){
        return contratosService.criarContrato(contratoRegistroDTO, fornecedor_id);
    }

    @GetMapping
    public List<Contratos> listContratos(){
        return contratosService.findAll();
    }

    @GetMapping("/{contrato_id}")
    public Contratos findContratosById(@PathVariable String contrato_id) {
        return contratosService.findContrato(contrato_id);
    }

    @PutMapping("/{contrato_id}")
    public Contratos atualizarContratos(@PathVariable String contrato_id, @RequestBody ContratoAtualizacaoDTO contratoAtualizacaoDTO) {
        contratoAtualizacaoDTO.setId(contrato_id);
        return contratosService.atualizarContrato(contratoAtualizacaoDTO);

    }

    @DeleteMapping("/{contrato_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarContrato(@PathVariable String contrato_id) {
        contratosService.deletaContrato(contrato_id);
    }

    @GetMapping("/dataInicio/{dataInicio}")
    public List<Contratos> findContratosByDataInicio(@PathVariable String fornecedor_id, @PathVariable LocalDate dataInicio) {
        return contratosService.findContratosByFornecedorAndDataInicio(fornecedor_id, dataInicio);
    }

    @GetMapping("/dataTermino/{dataTermino}")
    public List<Contratos> findContratosByDataTermino(@PathVariable String fornecedor_id, @PathVariable LocalDate dataTermino) {
        return contratosService.findContratosByFornecedorAndDataTermino(fornecedor_id, dataTermino);
    }

    @GetMapping("/ativo/{ativo}")
    public List<Contratos> findContratosByAtivo(@PathVariable String fornecedor_id, @PathVariable Boolean ativo) {
        return contratosService.findContratosByFornecedorAndAtivo(fornecedor_id, ativo);
    }

    @GetMapping("/descricao/{descricao}")
    public List<Contratos> findContratosByDescricao(@PathVariable String fornecedor_id, @PathVariable String descricao) {
        return contratosService.findContratosByFornecedorAndDescricao(fornecedor_id, descricao);
    }
}

