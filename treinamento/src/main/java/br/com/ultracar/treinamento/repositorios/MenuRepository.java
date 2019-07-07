package br.com.ultracar.treinamento.repositorios;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Menu;
import br.com.ultracar.treinamento.entidades.PermissaoAcesso;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

	
	@Query("Select menu From Menu menu Where menu = :menu Order by menu.descricao Asc ")
	public Menu findByMenuOrderByDescricaoAsc(@Nullable Menu menu);
	
	@Query("Select menu From Menu menu Where menu.permissaoAcesso = :permissao Order by menu.descricao Desc ")
	public Stream<Menu> findByPermissaoAcessoOrderByDescricaoDesc(@Nullable PermissaoAcesso permissao); 
	
	@Query("Select m From Menu m Where m.menu = :menu")
	public Menu findMenuByMenuPai(Menu menu);
}
