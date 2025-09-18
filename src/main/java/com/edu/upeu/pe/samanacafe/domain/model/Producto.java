package com.edu.upeu.pe.samanacafe.domain.model;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.Categoria;

import java.math.BigDecimal;

public class Producto {

    private Long id;
    private String name;
    private Categoria categoria;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private byte[] imagen;

    public Producto() {}

    public Producto(Long id, String name, Categoria categoria, String descripcion,
                    BigDecimal precio, Integer stock, byte[] imagen) {
        this.id = id;
        this.name = name;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.imagen = imagen;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public byte[] getImagen() { return imagen; }
    public void setImagen(byte[] imagen) { this.imagen = imagen; }
}
