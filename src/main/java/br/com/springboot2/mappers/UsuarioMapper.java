package br.com.springboot2.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.springboot2.domain.UsuarioDomain;
import br.com.springboot2.models.UsuarioModel;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {
	public static final UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

	public abstract UsuarioDomain modelToDomain(UsuarioModel model);

	public abstract UsuarioModel domainToModel(UsuarioDomain domain);

	public abstract List<UsuarioModel> toModel(List<UsuarioDomain> domains);

	public abstract List<UsuarioDomain> toDomain(List<UsuarioModel> models);
}
