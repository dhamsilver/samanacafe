package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Domain.Port.On.ProductoRepositoryPort;
import pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Mapper.ProductoMapper;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.CategoriaProducto;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.ProductoEntity;

import java.util.List;
import java.util.Optional;

@Component
public class ProductoPersistenceAdapter implements ProductoRepositoryPort {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoPersistenceAdapter(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    public Producto save(Producto p) {
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setName(p.getName());
        productoEntity.setDescripcion(p.getDescripcion());
        productoEntity.setCategoriaProducto(p.getCategoriaProducto());
        productoEntity.setPrecio(p.getPrecio());

        ProductoEntity savedProducto = productoRepository.save(productoEntity);
        return productoMapper.toDomainModel(savedProducto);

    }

    @Override
    public Producto update(Long id, Producto p) {
        ProductoEntity productoEntity = productoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Producto no encontrado"));

        productoEntity.setName(p.getName());
        productoEntity.setDescripcion(p.getDescripcion());
        productoEntity.setCategoriaProducto(p.getCategoriaProducto());
        productoEntity.setPrecio(p.getPrecio());

        ProductoEntity updateProducto = productoRepository.save(productoEntity);
        return productoMapper.toDomainModel(updateProducto);

    }

    @Override
    public Boolean deleteById(Long id) {
        if (productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id)
                .map(productoMapper::toDomainModel);
    }

    @Override
    public List<Producto> findAll() {
        List<ProductoEntity> productoEntities = productoRepository.findAll();

        return productoMapper.toDomainModelList(productoEntities);
    }

    @Override
    public List<Producto> findByCategoria(CategoriaProducto categoriaProducto) {
        List<ProductoEntity> productoEntities = productoRepository.findByCategoriaProducto(categoriaProducto);
        return productoMapper.toDomainModelList(productoEntities);
    }
}
