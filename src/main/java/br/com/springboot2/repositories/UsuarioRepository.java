package br.com.springboot2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot2.models.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

}
