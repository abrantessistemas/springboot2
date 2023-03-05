package br.com.springboot2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springboot2.domain.UsuarioDomain;
import br.com.springboot2.mappers.UsuarioMapper;
import br.com.springboot2.models.UsuarioModel;
import br.com.springboot2.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public List<UsuarioDomain> findAll() {
		return UsuarioMapper.INSTANCE.toDomain(repository.findAll());
	}

	@Transactional
	public UsuarioModel save(UsuarioDomain usuario) {
		return repository.save(UsuarioMapper.INSTANCE.domainToModel(usuario));
	}
}
