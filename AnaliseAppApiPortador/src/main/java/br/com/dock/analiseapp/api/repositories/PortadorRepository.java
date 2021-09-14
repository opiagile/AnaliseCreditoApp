package br.com.dock.analiseapp.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.dock.analiseapp.api.models.Portador;

@Repository
public interface PortadorRepository extends JpaRepository<Portador, Long>{

	@Query(value = "select * from Portador p inner join proposta prt on p.proposta_id = prt.id where prt.status != 0 and prt.credito between ?1 and ?2", nativeQuery = true)
	List<Portador> findByAnliseCredito(float minCred, float maxCred);

	@Query(value = "select * from Portador p inner join proposta prt on p.proposta_id = prt.id where prt.status = 0 and prt.credito between ?1 and ?2", nativeQuery = true)	
	List<Portador> findByPendentes(float minCred, float maxCred);

	Portador findByCpf(String cpf);

}
