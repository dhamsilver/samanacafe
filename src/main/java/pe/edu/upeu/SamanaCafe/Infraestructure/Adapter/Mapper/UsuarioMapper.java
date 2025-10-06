package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Mapper;

import org.mapstruct.Mapper;
import pe.edu.upeu.SamanaCafe.Domain.Model.Usuario;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.UsuarioEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toDomainModel (UsuarioEntity entity);

    UsuarioEntity toEntiy(Usuario domainModel);

    List<Usuario> toDomainModelList(List<UsuarioEntity> entities);
}
