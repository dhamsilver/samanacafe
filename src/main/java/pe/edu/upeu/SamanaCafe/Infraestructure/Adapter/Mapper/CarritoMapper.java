package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Mapper;

import org.mapstruct.Mapper;
import pe.edu.upeu.SamanaCafe.Domain.Model.Carrito;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.CarritoEntity;


@Mapper(componentModel = "spring")
public interface CarritoMapper {

    Carrito toDomainModel (CarritoEntity entity);

    CarritoEntity toEntiy(Carrito domainModel);

}
