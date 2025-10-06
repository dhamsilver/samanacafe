package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Mapper;

import org.mapstruct.Mapper;
import pe.edu.upeu.SamanaCafe.Domain.Model.Venta;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.VentaEntity;

@Mapper(componentModel = "spring")
public interface VentaMapper {

    Venta toDomainModel (VentaEntity entity);

    VentaEntity toEntiy(Venta domainModel);

}
