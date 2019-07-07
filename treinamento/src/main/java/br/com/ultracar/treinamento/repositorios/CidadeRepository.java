package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Bairro;
import br.com.ultracar.treinamento.entidades.Cidade;
import br.com.ultracar.treinamento.entidades.Estado;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	@Query("Select cidade From Cidade cidade "
			+ "Where cidade.id = :id")
	public Cidade findCidadeById(Long id);
	
	@Query("Select cidade From Cidade cidade"
			+ "Where cidade.nome like %?1%")
	public Cidade findCidadeByNome(String nome);
	
	@Query("Select estado From Cidade cidade"
			+ "Inner Join cidade.estado estado"
			+ "Where cidade = :cidade")
	public Estado getEstadoByCidade(Cidade cidade);
	
	@Query("Select bairros From Cidade cidade "
			+ "Inner Join cidade.bairros bairros"
			+ "Where cidade = :cidade")
	public List<Bairro> getBairrosByCidade(Cidade cidade);
	
	
}
