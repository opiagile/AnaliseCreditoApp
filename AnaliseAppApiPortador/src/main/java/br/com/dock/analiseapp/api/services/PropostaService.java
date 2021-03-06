package br.com.dock.analiseapp.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dock.analiseapp.api.models.Portador;
import br.com.dock.analiseapp.api.models.Proposta;
import br.com.dock.analiseapp.api.repositories.PropostaRepository;

import org.springframework.web.server.ResponseStatusException;

import org.springframework.http.HttpStatus;

@Service
public class PropostaService {

	@Autowired
	PropostaRepository propostaRepository;

	@Autowired
	PortadorService portadorService;

	@Autowired
	UsuarioService usuarioService;

	private float minCred = 1000;
	private float maxCred = 1000000;

	public List<Portador> listarPortadores(Float minCredito, Float maxCredito, long idUsuario) throws Exception {

		List<Portador> portadores = null;

		if (minCredito != null) {
			minCred = minCredito;
		}

		if (maxCredito != null) {
			maxCred = maxCredito;
		}

		if (usuarioService.tipoPermissao(idUsuario, 1)) {
			portadores = portadorService.AnliseCredito(minCred, maxCred);
		} else if (usuarioService.tipoPermissao(idUsuario, 0)) {
			portadores = portadorService.getPendentes(minCred, maxCred);
		} else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario não autorizado");
		}

		if (portadores.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma resultado encontrado");
		} else {
			return portadores;
		}
	}

	public Proposta atualizaStatus(Proposta proposta, long usuarioId) {
		if (usuarioService.tipoPermissao(usuarioId, 0)) {
			return propostaRepository.save(proposta);
		} else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
					"Usuario não autorizado");
		}
	}
	
	public Proposta findById(Long Id) {
		return propostaRepository.findById(Id).get();
	}
	
}
