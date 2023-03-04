package br.com.springboot2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.springboot2.models.UsuarioModel;
import br.com.springboot2.repositories.UsuarioRepository;

public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public List<UsuarioModel> findAll() {
		return repository.findAll();
	}

	@Transactional
	public UsuarioModel save(UsuarioModel usuario) {
		return repository.save(usuario);
	}
}
