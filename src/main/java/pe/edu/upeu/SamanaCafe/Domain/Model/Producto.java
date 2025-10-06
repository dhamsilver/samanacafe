package pe.edu.upeu.SamanaCafe.Domain.Model;

import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.CategoriaProducto;

import java.math.BigDecimal;

public class Producto {

    private Long id;

    private String name;

    private String descripcion;

    private CategoriaProducto categoriaProducto;

    private BigDecimal precio;

    public Producto() {
    }

    public Producto(Long id, String name, BigDecimal precio) {
        this.id = id;
        this.name = name;
        this.precio = precio;
    }

    public Producto(Long id, String name, String descripcion, CategoriaProducto categoriaProducto, BigDecimal precio) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.categoriaProducto = categoriaProducto;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
