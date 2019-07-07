package br.com.ultracar.treinamento.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entidades.Usuario;
import br.com.ultracar.treinamento.repositorios.UsuarioRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repositorio;
	
	public Usuario findOne(Long id){
		return this.repositorio.getOne(id);
	}
	
	public void salvarUsuario(Usuario usuario) {
		this.repositorio.save(usuario);
	}
	
	public void deletarUsuario(Usuario usuario) {
		this.repositorio.deleteById(usuario.getId());
	}
	
	public void deletarMuitosUsuario(List<Long> ids) {
		ids.parallelStream().forEach(id -> {
			if(this.repositorio.existsById(id)) {
				this.repositorio.deleteById(id);
			}
		});
	}	
	
	public List<Usuario> findAll(){
		return repositorio.findAll();
	}
	
	public void updateUser(Usuario usuario) {
		Usuario user = this.repositorio.getOne(usuario.getId());
		this.repositorio.UpdateUser(user);
	}
	
	
	
}
