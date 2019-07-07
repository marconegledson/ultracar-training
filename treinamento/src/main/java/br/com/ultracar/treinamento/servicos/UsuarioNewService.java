package br.com.ultracar.treinamento.servicos;



import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.repositorios.UsuarioRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioNewService {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	public void deletarUmUsuario(Long id) {
		this.usuarioRepo.deleteById(id);		
	}
	
}
