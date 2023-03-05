package br.com.springboot2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springboot2.domain.UserDomain;
import br.com.springboot2.exceptions.BadRequestException;
import br.com.springboot2.mappers.UserMapper;
import br.com.springboot2.models.UserModel;
import br.com.springboot2.repositories.UserRepository;
import br.com.springboot2.utils.LanguageSystem;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<UserDomain> findAll() {
		return UserMapper.INSTANCE.toDomain(repository.findAll());
	}

	@Transactional
	public UserDomain save(UserModel usuario) {
		return UserMapper.INSTANCE.modelToDomain(repository.save(usuario));
	}

	public UserDomain findById(long id) {
		return UserMapper.INSTANCE.modelToDomain(
				repository.findById(id).orElseThrow(() -> new BadRequestException(new LanguageSystem().translater("User not found."))));
	}
}
