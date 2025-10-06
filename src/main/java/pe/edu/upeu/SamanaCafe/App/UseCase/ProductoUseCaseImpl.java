package pe.edu.upeu.SamanaCafe.App.UseCase;

import org.springframework.stereotype.Service;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Domain.Port.In.ProductoUseCase;
import pe.edu.upeu.SamanaCafe.Domain.Port.On.ProductoRepositoryPort;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.CategoriaProducto;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoUseCaseImpl implements ProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public ProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Producto crearProducto(Producto p) {
        return productoRepositoryPort.save(p);
    }

    @Override
    public Optional<Producto> updateProducto(Long id, Producto p) {
        try {
            Producto ProductoUpdate = productoRepositoryPort.update(id, p);
            return Optional.of(ProductoUpdate);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Boolean deleteProducto(Long id) {
        return productoRepositoryPort.deleteById(id);
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepositoryPort.findAll();
    }

    @Override
    public List<Producto> findByCategoria(CategoriaProducto categoriaProducto) {
        return productoRepositoryPort.findByCategoria(categoriaProducto);
    }
}
