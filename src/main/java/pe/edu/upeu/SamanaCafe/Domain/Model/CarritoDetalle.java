package pe.edu.upeu.SamanaCafe.Domain.Model;

import java.math.BigDecimal;

public class CarritoDetalle {

    private Long id;

    private Venta venta;

    private Producto producto;

    private Integer cantidad;

    private BigDecimal subTotal;

    public CarritoDetalle() {
    }

    public CarritoDetalle(Long id, Venta venta, Producto producto, Integer cantidad, BigDecimal subTotal) {
        this.id = id;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
}
