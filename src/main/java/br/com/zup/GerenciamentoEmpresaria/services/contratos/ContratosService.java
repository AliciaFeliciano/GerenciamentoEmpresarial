package br.com.zup.GerenciamentoEmpresaria.services.contratos;

import br.com.zup.GerenciamentoEmpresaria.controllers.contrato.dtos.ContratoAtualizacaoDTO;
import br.com.zup.GerenciamentoEmpresaria.controllers.contrato.dtos.ContratoRegistroDTO;
import br.com.zup.GerenciamentoEmpresaria.models.Contratos;
import br.com.zup.GerenciamentoEmpresaria.models.Fornecedor;
import br.com.zup.GerenciamentoEmpresaria.repositorys.ContratoRepository;
import br.com.zup.GerenciamentoEmpresaria.repositorys.FornecedorRepository;
import br.com.zup.GerenciamentoEmpresaria.services.contratos.mapper.ContratosMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContratosService {

    @Autowired
    private ContratoRepository contratoRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public ContratosService(ContratoRepository contratoRepository, FornecedorRepository fornecedorRepository) {
        this.contratoRepository = contratoRepository;
        this.fornecedorRepository = fornecedorRepository;
    }

    @Transactional
    public Contratos criarContrato(ContratoRegistroDTO contratoRegistroDTO, String fornecedor_id) {
        Fornecedor fornecedor = fornecedorRepository.findById(fornecedor_id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        Contratos contratos = ContratosMapper.fromContratoRegistro(contratoRegistroDTO);
        contratos.setFornecedor(fornecedor);
        contratos.setAtivo(atualizarAtivo(contratoRegistroDTO.getDataInicio(), contratoRegistroDTO.getDataTermino()));
        validarDatas(contratoRegistroDTO.getDataInicio(), contratoRegistroDTO.getDataTermino());

        return contratoRepository.save(contratos);
    }

    @Transactional
    public List<Contratos> findAll() {
        return contratoRepository.findAll();
    }

    @Transactional
    public Contratos findContrato(String id) {
        return contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
    }

    @Transactional
    public Contratos atualizarContrato(ContratoAtualizacaoDTO contratoAtualizacaoDTO) {
        Contratos contratosBD = findContrato(contratoAtualizacaoDTO.getId());
        validarDatas(contratoAtualizacaoDTO.getDataInicio(), contratoAtualizacaoDTO.getDataTermino());

        contratosBD.setNumeroContrato(contratoAtualizacaoDTO.getNumeroContrato());
        contratosBD.setDataTermino(contratoAtualizacaoDTO.getDataTermino());
        contratosBD.setDataInicio(contratoAtualizacaoDTO.getDataInicio());
        contratosBD.setDescricao(contratoAtualizacaoDTO.getDescricao());
        contratosBD.setAtivo(atualizarAtivo(contratoAtualizacaoDTO.getDataInicio(), contratoAtualizacaoDTO.getDataTermino()));

        return contratoRepository.save(contratosBD);
    }

    @Transactional
    public void deletaContrato(String contrato_id) {
        contratoRepository.deleteById(contrato_id);
    }

    @Transactional
    public boolean atualizarAtivo(LocalDate dataInicio, LocalDate dataTermino) {
        LocalDate hoje = LocalDate.now();
        return (dataInicio != null && dataTermino != null) &&
                (hoje.isAfter(dataInicio) || hoje.isEqual(dataInicio)) &&
                (hoje.isBefore(dataTermino) || hoje.isEqual(dataTermino));
    }

    @Transactional
    public void validarDatas(LocalDate dataInicio, LocalDate dataTermino) {
        if (dataInicio != null && dataTermino != null && dataTermino.isBefore(dataInicio)) {
            throw new IllegalArgumentException("A data de término deve ser maior que a data de início.");
        }
    }

    //Pesquisas

    @Transactional
    public List<Contratos> findContratos(String fornecedor_id, LocalDate dataInicial, LocalDate dataTermino, Boolean ativo, String descricao) {

        if (dataInicial != null) {
            return contratoRepository.findByFornecedorIdAndDataInicio(fornecedor_id, dataInicial)
                    .orElseThrow(() -> new RuntimeException("Nenhum contrato encontrado com a data de início fornecida"));
        } else if (dataTermino != null) {
            return contratoRepository.findByFornecedorIdAndDataTermino(fornecedor_id, dataTermino)
                    .orElseThrow(() -> new RuntimeException("Nenhum contrato encontrado com a data de término fornecida"));
        } else if (ativo != null) {
            return contratoRepository.findByFornecedorIdAndAtivo(fornecedor_id, ativo)
                    .orElseThrow(() -> new RuntimeException("Nenhum contrato encontrado com o status ativo fornecido"));
        } else if (descricao != null) {
            return contratoRepository.findByFornecedorIdAndDescricaoContaining(fornecedor_id, descricao)
                    .orElseThrow(() -> new RuntimeException("Nenhum contrato encontrado com a descrição fornecida"));
        } else {
            return contratoRepository.findByFornecedorId(fornecedor_id);
        }

    }

    @Transactional
    @Scheduled(cron = "0 0 * * * *")
    public void atualizarStatusContratos() {
        LocalDate hoje = LocalDate.now();
        List<Contratos> contratos = contratoRepository.findByDataTerminoLessThanEqualAndAtivo(hoje, true);

        for (Contratos contrato : contratos) {
            contrato.setAtivo(false);
            contratoRepository.saveAndFlush(contrato);
        }
    }

}