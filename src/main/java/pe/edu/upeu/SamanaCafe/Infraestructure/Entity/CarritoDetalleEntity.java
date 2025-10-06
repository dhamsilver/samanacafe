package pe.edu.upeu.SamanaCafe.Infraestructure.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "carrito_detalle")
public class CarritoDetalleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private VentaEntity carrito;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoEntity producto;

    @Column(nullable = false)
    private Integer cantidad = 1;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    public CarritoDetalleEntity() {
    }

    public CarritoDetalleEntity(Long id, VentaEntity carrito, ProductoEntity producto, Integer cantidad, BigDecimal subtotal) {
        this.id = id;
        this.carrito = carrito;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public VentaEntity getCarrito() { return carrito; }
    public void setCarrito(VentaEntity carrito) { this.carrito = carrito; }

    public ProductoEntity getProducto() { return producto; }
    public void setProducto(ProductoEntity producto) { this.producto = producto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        actualizarSubtotal();
    }

    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }

    // Método para calcular subtotal automáticamente
    public void actualizarSubtotal() {
        if (producto != null && cantidad != null) {
            this.subtotal = producto.getPrecio().multiply(BigDecimal.valueOf(cantidad));
        } else {
            this.subtotal = BigDecimal.ZERO;
        }
    }
}

