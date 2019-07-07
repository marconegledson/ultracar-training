package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ultracar.treinamento.entidades.Endereco;
import br.com.ultracar.treinamento.entidades.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, Long> {

	@Query("Select ponto From Ponto ponto Where ponto.endereco = :endereco ")
	public List<Ponto> findPontoByEndereco(Endereco endereco);
	
}
