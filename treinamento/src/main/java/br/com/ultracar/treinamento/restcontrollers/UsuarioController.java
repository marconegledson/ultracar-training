package br.com.ultracar.treinamento.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ultracar.treinamento.entidades.Usuario;
import br.com.ultracar.treinamento.servicos.UsuarioNewService;
import br.com.ultracar.treinamento.servicos.UsuarioService;

@RestController
@RequestMapping("/api/usuario/")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	private UsuarioNewService serviceDelete;

	public ResponseEntity<?> restGet(@PathVariable(name = "id",required = true) Long idUsuario){
		Usuario usuario = service.findOne(idUsuario);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@GetMapping
	public List<Usuario> restGetAll(){
		return service.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void restDelete(@PathVariable("id") Long id){
		serviceDelete.deletarUmUsuario(id);			
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void restUpdate(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
		service.updateUser(usuario);
	}
	
}
