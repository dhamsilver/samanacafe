package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Mapper;

import org.mapstruct.Mapper;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.ProductoEntity;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.UsuarioEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    Producto toDomainModel (ProductoEntity entity);

    ProductoEntity toEntiy(Producto domainModel);

    List<Producto> toDomainModelList(List<ProductoEntity> entities);
}
