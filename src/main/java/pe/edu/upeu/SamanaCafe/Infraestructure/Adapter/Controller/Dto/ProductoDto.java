package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller.Dto;

import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.CategoriaProducto;

import java.math.BigDecimal;

public record ProductoDto() {

    public record ProductoRequest(
            String name,
            String descripcion,
            CategoriaProducto categoriaProducto,
            BigDecimal precio
    ) {}

    public record ProductoResponse(
            Long id,
            String name,
            String descripcion,
            CategoriaProducto categoriaProducto,
            BigDecimal precio
    ) {}
}
