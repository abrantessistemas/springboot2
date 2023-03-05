package br.com.springboot2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot2.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
