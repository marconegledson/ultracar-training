package br.com.ultracar.treinamento.repositorios;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Bairro;
import br.com.ultracar.treinamento.entidades.Cidade;
import br.com.ultracar.treinamento.entidades.Endereco;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long>{
	
	@Query("Select b from Bairro b Where b.id = :id")
	public Bairro findBairroById(Long id);
		
	@Query("Select b from Bairro b Where b.nome = :nome")
	public Bairro findBairroByNome(String nome);
	
	@Query("Select cidade From Bairro bairro "
			+ "Inner Join bairro.cidade cidade"
			+ "Where bairro = :bairro")
	public Cidade findCidadeByBairro(Bairro bairro);
	
	@Query("Select enderecos Bairro bairro"
			+ "Inner Join bairro.enderecos enderecos"
			+ "Where bairro = :bairro")
	public List<Endereco> findEnderecoByBairro(Bairro bairro);
	
	@Query("Select bairro From Bairro bairro Where bairro.cidade = ?1")
	public List<Bairro> findByCidade(Cidade cidade);
	

}
