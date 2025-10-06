package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Mapper;

import pe.edu.upeu.SamanaCafe.Domain.Model.Imagen;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.ImagenEntity;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.ProductoEntity;

public interface ImagenMapper {

    // 🔹 De Entity → Domain
    static Imagen imagentoDomain(ImagenEntity entity) {
        if (entity == null) return null;

        Producto producto = null;
        if (entity.getProducto() != null) {
            producto = new Producto();
            producto.setId(entity.getProducto().getId());
            producto.setName(entity.getProducto().getName());
            producto.setDescripcion(entity.getProducto().getDescripcion());
            producto.setCategoriaProducto(entity.getProducto().getCategoriaProducto());
            producto.setPrecio(entity.getProducto().getPrecio());
        }

        return new Imagen(
                entity.getId(),
                entity.getNombreArchivo(),
                entity.getUrl(),
                producto
        );
    }

    // 🔹 De Domain → Entity
    static ImagenEntity imagentoEntity(Imagen domain) {
        if (domain == null) return null;

        ProductoEntity productoEntity = null;
        if (domain.getProducto() != null) {
            productoEntity = new ProductoEntity();
            productoEntity.setId(domain.getProducto().getId());
            productoEntity.setName(domain.getProducto().getName());
            productoEntity.setDescripcion(domain.getProducto().getDescripcion());
            productoEntity.setCategoriaProducto(domain.getProducto().getCategoriaProducto());
            productoEntity.setPrecio(domain.getProducto().getPrecio());
        }

        ImagenEntity entity = new ImagenEntity();
        entity.setId(domain.getId());
        entity.setNombreArchivo(domain.getNombreArchivo());
        entity.setUrl(domain.getUrl());
        entity.setProducto(productoEntity);

        return entity;
    }
}
