package br.com.springboot2.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

	public Page<UserDomain> findAll(int page, int pageSize) {
		Page<UserModel> list = repository.findAll(PageRequest.of(page - 1, pageSize, Sort.by("name").ascending()));

		return new PageImpl<UserDomain>(UserMapper.INSTANCE.toDomain(list.getContent()), list.getPageable(),
				list.getTotalElements());
	}

	@Transactional
	public UserDomain save(UserModel user) {
		user.setCreateAt(LocalDateTime.now().toString());
		return UserMapper.INSTANCE.modelToDomain(repository.save(user));
	}

	public UserDomain findById(long id) {
		return UserMapper.INSTANCE.modelToDomain(repository.findById(id)
				.orElseThrow(() -> new BadRequestException(new LanguageSystem().translater("User not found."))));
	}

	public void delete(long id) {
		UserModel uModel = UserMapper.INSTANCE.domainToModel(this.findById(id));

		if (!uModel.equals(null)) {
			repository.delete(uModel);
		}
	}

	public UserDomain update(UserModel user) {
		return UserMapper.INSTANCE.modelToDomain(repository.saveAndFlush(user));
	}
}
