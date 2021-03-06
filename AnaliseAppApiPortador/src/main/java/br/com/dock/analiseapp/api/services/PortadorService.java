package br.com.dock.analiseapp.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.dock.analiseapp.api.enums.Status;
import br.com.dock.analiseapp.api.models.Portador;
import br.com.dock.analiseapp.api.repositories.PortadorRepository;
import br.com.dock.analiseapp.api.repositories.PropostaRepository;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PortadorService {

	@Autowired
	PortadorRepository portadorRepository;

	@Autowired
	PropostaRepository propostaRepository;

	@Autowired
	UsuarioService usuarioService;
	
	public List<Portador> AnliseCredito(float minCred, float maxCred) {
		return portadorRepository.findByAnliseCredito(minCred, maxCred);
	}

	public List<Portador> getPendentes(float minCred, float maxCred) {
		return portadorRepository.findByPendentes(minCred, maxCred);
	}

	public Portador cadastrarPortador(Portador portador, long idUsuario) {
		if (usuarioService.tipoPermissao(idUsuario, 1)) {
			if (portadorRepository.findByCpf(portador.getCpf()) != null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já existe para um portador");
			} else {
				portador.getProposta().setStatus(Status.PENDENTE);
				
				propostaRepository.save(portador.getProposta());
				
				return portadorRepository.save(portador);
			}
		} else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario não autorizado");
		}
	}
	
	public Portador findById(Long Id) {
		return portadorRepository.findById(Id).get();
	}
	
}
