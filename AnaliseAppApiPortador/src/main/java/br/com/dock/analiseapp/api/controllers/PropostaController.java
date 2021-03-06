package br.com.dock.analiseapp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.com.dock.analiseapp.api.models.Portador;
import br.com.dock.analiseapp.api.models.Proposta;
import br.com.dock.analiseapp.api.services.PropostaService;

@RestController
@RequestMapping(value = "/proposta")
public class PropostaController {

	@Autowired
	PropostaService propostaService;

	@GetMapping
	public Proposta findById(@RequestParam(required = true) long id) {
		return propostaService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listar-propostas", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<Portador> listarPropostas(@RequestParam(required = false) long usuarioId,
			@RequestParam(required = false) Float minCredito, @RequestParam(required = false) Float maxCredito)
			throws Exception {

		return propostaService.listarPortadores(minCredito, maxCredito, usuarioId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/atualiza-proposta", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Proposta atualizarProposta(@RequestParam(required = true) long usuarioId,
			@RequestBody(required = true) Proposta proposta) throws Exception {

		return propostaService.atualizaStatus(proposta, usuarioId);
	}
}
