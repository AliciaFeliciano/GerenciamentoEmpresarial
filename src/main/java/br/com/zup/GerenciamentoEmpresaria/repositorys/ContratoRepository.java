package br.com.zup.GerenciamentoEmpresaria.repositorys;

import br.com.zup.GerenciamentoEmpresaria.models.Contratos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContratoRepository extends JpaRepository<Contratos, String> {
    Optional<List<Contratos>> findByFornecedorIdAndDataInicio(String fornecedor_id, LocalDate dataInicio);

    Optional<List<Contratos>> findByFornecedorIdAndDataTermino(String fornecedor_id, LocalDate dataTermino);

    Optional<List<Contratos>> findByFornecedorIdAndAtivo(String fornecedor_id, Boolean ativo);

    Optional<List<Contratos>> findByFornecedorIdAndDescricaoContaining(String fornecedor_id, String descricao);

}