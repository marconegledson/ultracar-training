package br.com.ultracar.treinamento.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Usuario;

@Repository
public interface CustomizedUsuarioRepository {
	
	Page<Usuario> findByFilter(Usuario usuario, Pageable pageable);
	
}
