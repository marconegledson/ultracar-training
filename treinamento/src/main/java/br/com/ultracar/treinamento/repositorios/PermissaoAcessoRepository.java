package br.com.ultracar.treinamento.repositorios;

import java.util.concurrent.Future;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.GrupoAcesso;
import br.com.ultracar.treinamento.entidades.PermissaoAcesso;
import br.com.ultracar.treinamento.entidades.Usuario;


@Repository
public interface PermissaoAcessoRepository extends JpaRepository<PermissaoAcesso, Long> {

	@Query("Select permissao From PermissaoAcesso permissao Where permissao.usuario = :usuario ")
	public Page<PermissaoAcesso> findByUsuario(Usuario usuario, Pageable pageable);
	
	@Async
	@Query("Select permissao From PermissaoAcesso permissao Where permissao.grupoAcesso = :grupo ")
	public Future<PermissaoAcesso> findByGrupoAcesso(GrupoAcesso grupo);
	
}
