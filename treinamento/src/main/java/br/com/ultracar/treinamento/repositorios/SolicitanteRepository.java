package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ultracar.treinamento.entidades.Endereco;
import br.com.ultracar.treinamento.entidades.Solicitante;

public interface SolicitanteRepository extends JpaRepository<Solicitante, Long>{

	@Query("Select sol From Solicitante sol Where sol.endereco = :endereco ")
	public List<Solicitante> findSolicitanteByEndereco(Endereco endereco);
	
}
