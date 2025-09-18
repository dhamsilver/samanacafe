package com.edu.upeu.pe.samanacafe.domain.model;

import java.math.BigDecimal;

public class OrdenDetalle {

    private Long id;
    private Orden orden;
    private Producto producto;
    private Integer cantidad;
    private BigDecimal subtotal;

    public OrdenDetalle() {}

    public OrdenDetalle(Long id, Orden orden, Producto producto, Integer cantidad, BigDecimal subtotal) {
        this.id = id;
        this.orden = orden;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Orden getOrden() { return orden; }
    public void setOrden(Orden orden) { this.orden = orden; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}


