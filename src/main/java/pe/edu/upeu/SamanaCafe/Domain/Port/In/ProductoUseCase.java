package pe.edu.upeu.SamanaCafe.Domain.Port.In;



import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.CategoriaProducto;

import java.util.List;
import java.util.Optional;

public interface ProductoUseCase {

    Producto crearProducto(Producto p);

    Optional<Producto> updateProducto (Long id, Producto p);

    Boolean deleteProducto(Long id);

    List<Producto> getAllProductos();

    List<Producto> findByCategoria(CategoriaProducto categoriaProducto);

}
