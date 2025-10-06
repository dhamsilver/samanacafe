package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.CategoriaProducto;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.ProductoEntity;

import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
    List<ProductoEntity> findByCategoriaProducto(CategoriaProducto categoriaProducto);
}
