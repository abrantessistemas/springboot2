package br.com.springboot2.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot2.domain.UsuarioDomain;
import br.com.springboot2.mappers.UsuarioMapper;
import br.com.springboot2.services.UsuarioService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {
	private UsuarioService usuarioService;

	@PostMapping("/save")
	public ResponseEntity<UsuarioDomain> createUsuario(@RequestBody UsuarioDomain payload) {
		return new ResponseEntity<>(UsuarioMapper.INSTANCE.modelToDomain(usuarioService.save(payload)),
				HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<UsuarioDomain>> findAll() {
		return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
	}
}
