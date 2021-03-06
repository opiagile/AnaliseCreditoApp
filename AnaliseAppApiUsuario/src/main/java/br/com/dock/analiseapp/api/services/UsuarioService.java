package br.com.dock.analiseapp.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import br.com.dock.analiseapp.api.models.Usuario;
import br.com.dock.analiseapp.api.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public Boolean possuiPermissao (long id, int permissao) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);

		if (usuario.isPresent() ) {
			return usuario.get().getPermissao().ordinal() == permissao ? true : false;
		} else {
			return false; 
		}
		
	}	
}
