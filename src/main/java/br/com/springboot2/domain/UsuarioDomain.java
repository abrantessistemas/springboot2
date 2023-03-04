package br.com.springboot2.domain;

import lombok.Data;

@Data
public class UsuarioDomain {
	private long id;
	private String dataCriacao;
	private boolean ativo;
	private String nome;
	private String email;
	private String senha;
}
