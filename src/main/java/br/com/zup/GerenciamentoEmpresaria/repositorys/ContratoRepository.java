package br.com.zup.GerenciamentoEmpresaria.repositorys;

import br.com.zup.GerenciamentoEmpresaria.models.Contratos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contratos,String> {
}
