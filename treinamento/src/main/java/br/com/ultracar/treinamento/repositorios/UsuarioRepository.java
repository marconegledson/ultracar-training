package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Operacao;
import br.com.ultracar.treinamento.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Nullable
	@Query("Select u From Usuario u Where u.login = :login ")
	public Usuario findUsuarioByLogin(String login);

	@Query("Select u From Usuario u Where u.senha = :senha ")
	public Usuario findUsuarioBySenha(String senha);

	@Query("Select operacoes From Usuario usuario " + "Inner Join usuario.permissoesDeAcesso permissoesDeAcesso "
			+ "Inner Join permissoesDeAcesso.operacoes operacoes " + "Where usuario = :usuario ")
	public List<Operacao> findOperacaoByUsuario(Usuario usuario);

	@Query("Select operacoes From Usuario usuario " + "Inner Join usuario.permissoesDeAcesso permissoesDeAcesso "
			+ "Inner Join permissoesDeAcesso.operacoes operacoes " + "Where usuario.id = :idUsuario ")
	public List<Operacao> findOperacaoByUsuario(@Param("idUsuario") Long id);

	@Query("Select us From Usuario us")
	public List<Usuario> findAll();

	@Modifying
	@Query("Update Usuario usr Set Where usu = :usuario")
	public void UpdateUser(Usuario usuario);

}
