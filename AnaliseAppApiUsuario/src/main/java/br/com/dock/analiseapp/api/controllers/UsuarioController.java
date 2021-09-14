package br.com.dock.analiseapp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dock.analiseapp.api.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {	
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/status/check")
	public String status() {
		return "Usuarios working";
	}
	
	@GetMapping("/permissao")
	public Boolean getPermissao(@RequestParam(required = true) long id, @RequestParam(required = true) int permissao) {
		return usuarioService.possuiPermissao(id, permissao);
	}	
}
