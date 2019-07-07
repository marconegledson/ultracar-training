package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ultracar.treinamento.entidades.GrupoAcesso;
import br.com.ultracar.treinamento.entidades.Usuario;

public interface GrupoAcessoRepository extends JpaRepository<GrupoAcesso, Long> {

	
	@Query("Select ga From GrupoAcesso ga Where ga.usuario = :usuario Order By ga.id Limit 0,10 ")
	Page<GrupoAcesso> findTop10ByUsuario(Usuario usuario, Pageable pageable);
	
	@Query("Select ga From GrupoAcesso ga Where ga.usuario = :usuario Order By ga.id Asc Limit 0,10 ") 
	List<GrupoAcesso> findFirst10ByUsuario(Usuario usuario, Sort sort);
	
}
