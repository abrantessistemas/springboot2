package br.com.springboot2.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserDomain {
	private long id;
	private String createAt;
	private boolean active;
	@NotEmpty
	private String name;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String password;
}
