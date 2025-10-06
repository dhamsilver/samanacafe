package pe.edu.upeu.SamanaCafe.Domain.Port.On;

import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.CategoriaProducto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {

    Producto save(Producto p);

    Producto update(Long id, Producto p);

    Boolean deleteById(Long id);

    Optional<Producto> findById(Long id);

    List<Producto> findAll();

    List<Producto> findByCategoria(CategoriaProducto categoriaProducto);
}
