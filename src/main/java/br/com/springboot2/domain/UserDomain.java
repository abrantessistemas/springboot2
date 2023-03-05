package br.com.springboot2.domain;

import lombok.Data;

@Data
public class UserDomain {
	private long id;
	private String createAt;
	private boolean active;
	private String name;
	private String email;
	private String password;
}
