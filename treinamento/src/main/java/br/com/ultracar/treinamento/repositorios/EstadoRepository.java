package br.com.ultracar.treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ultracar.treinamento.entidades.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

	@Query("Select e From Estado e Where e.sigla Like %?1% ")
	public Estado findEstadoBySigla(String sigla);
	
	
}
