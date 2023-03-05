package br.com.springboot2.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot2.domain.UserDomain;
import br.com.springboot2.mappers.UserMapper;
import br.com.springboot2.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<UserDomain> createUsuario(@RequestBody @Valid UserDomain payload) {
		return new ResponseEntity<>(userService.save(UserMapper.INSTANCE.domainToModel(payload)), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<UserDomain>> findAll() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDomain> findById(@PathVariable long id) {
		UserDomain ud = userService.findById(id);

		return new ResponseEntity<UserDomain>(ud, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		userService.delete(id);
	}

}
