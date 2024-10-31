package br.com.zup.GerenciamentoEmpresaria.repositorys;

import br.com.zup.GerenciamentoEmpresaria.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {
}
