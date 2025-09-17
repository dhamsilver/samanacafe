package com.edu.upeu.pe.samanacafe.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = true, length = 100)
    private String name;

    @Column(nullable = true, length = 200)
    private String descripcion;

    public ProductoEntity() {
    }

    public ProductoEntity(Long id, Categoria categoria, Integer stock, String name, String descripcion) {
        this.id = id;
        this.categoria = categoria;
        this.stock = stock;
        this.name = name;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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
}
