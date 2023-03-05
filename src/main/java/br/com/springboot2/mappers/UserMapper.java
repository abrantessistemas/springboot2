package br.com.springboot2.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.springboot2.domain.UserDomain;
import br.com.springboot2.models.UserModel;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
	public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	public abstract UserDomain modelToDomain(UserModel model);

	public abstract UserModel domainToModel(UserDomain domain);

	public abstract List<UserModel> toModel(List<UserDomain> domains);

	public abstract List<UserDomain> toDomain(List<UserModel> models);
}
