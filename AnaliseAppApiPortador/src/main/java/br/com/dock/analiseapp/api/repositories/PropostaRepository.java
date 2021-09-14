package br.com.dock.analiseapp.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dock.analiseapp.api.models.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long>{
	
}
