package br.com.dock.analiseapp.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dock.analiseapp.api.models.Portador;
import br.com.dock.analiseapp.api.services.PortadorService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(value = "/portador")
public class PortadorController {

	@Autowired
	PortadorService portadorService;

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Portador cadastrarPortador(@Valid @RequestParam(required = false) long usuarioId,
			@RequestBody Portador portador) throws Exception {

		return portadorService.cadastrarPortador(portador, usuarioId);
	}
	
	@GetMapping
	public Portador findById(@RequestParam(required = true) long id) {
		return portadorService.findById(id);
	}	
	

}
