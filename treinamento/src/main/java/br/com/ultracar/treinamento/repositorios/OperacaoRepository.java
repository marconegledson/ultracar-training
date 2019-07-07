package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Operacao;
import br.com.ultracar.treinamento.entidades.PermissaoAcesso;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long>{
	
	@Query("Select operacao from Operacao operacao "
			+ "Where operacao.id = :id ")
	public Operacao getOperacaoById(Long id);
	

	@Query("Select operacao from Operacao operacao "
			+ "Where operacao.descricao = :nome ")
	public Operacao getOperacaoByNome(String nome);
	
	
	@Query("Select permissao_acesso From Operacao operacao "
			+ "Inner Join operacao.permissoesDeAcesso permissoesDeAcesso "
			+ "Where operacao = :operacao ")
	public List<PermissaoAcesso> getPermissoesByOperacao(Operacao operacao);
	
	
	@Query("Select ope From Operacao ope Where ope.descricao = :descricao ")
	public Operacao findByDescricao(String descricao); 
	
	@Modifying
	@Query("Delete From Operacao ope Where ope.descricao = :descricao")
	public Integer deleteByDescricao(String descricao);
	
	@Modifying
	@Query("Update Operacao Set descricao = ?1 Where idOperacao = ?2")
	public Integer updateOperacaoById(String descricao, Long idOperacao);
	
}
