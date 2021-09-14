package br.com.dock.analiseapp.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioService {

	@Autowired
	RestTemplate restTemplate;

	private String BASE_URI = "http://localhost:8080/usuario";

	public Boolean tipoPermissao(final Long id, final int permissao) {
		String uri = BASE_URI + "/permissao?id=" + id + "&permissao=" + permissao;
		return restTemplate.getForObject(uri, Boolean.class);
	}
	
}
