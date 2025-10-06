package pe.edu.upeu.SamanaCafe.Domain.Model;

import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.EstadoVenta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Venta {

    private Long id;
    private Usuario usuario;
    private EstadoVenta estado;
    private BigDecimal total;
    private List<CarritoDetalle> productos = new ArrayList<>();

    public Venta() {
    }

    public Venta(Long id, Usuario usuario, EstadoVenta estado, BigDecimal total, List<CarritoDetalle> productos) {
        this.id = id;
        this.usuario = usuario;
        this.estado = estado;
        this.total = total;
        this.productos = productos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoVenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoVenta estado) {
        this.estado = estado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<CarritoDetalle> getProductos() {
        return productos;
    }

    public void setProductos(List<CarritoDetalle> productos) {
        this.productos = productos;
    }


    public void agregarProducto(Producto producto, int cantidad) {
        // Buscar si el producto ya está en el carrito
        CarritoDetalle detalleExistente = productos.stream()
                .filter(d -> d.getProducto().getId().equals(producto.getId()))
                .findFirst()
                .orElse(null);

        if (detalleExistente != null) {
            detalleExistente.setCantidad(detalleExistente.getCantidad() + cantidad);
            detalleExistente.setSubTotal(detalleExistente.getProducto().getPrecio().multiply(BigDecimal.valueOf(detalleExistente.getCantidad())));
        } else {
            CarritoDetalle nuevoDetalle = new CarritoDetalle();
            nuevoDetalle.setProducto(producto);
            nuevoDetalle.setCantidad(cantidad);
            nuevoDetalle.setSubTotal(producto.getPrecio().multiply(BigDecimal.valueOf(cantidad)));
            productos.add(nuevoDetalle);
        }

        actualizarTotal();
    }

    public void eliminarProducto(Long productoId) {
        productos.removeIf(d -> d.getProducto().getId().equals(productoId));
        actualizarTotal();
    }

    public void actualizarTotal() {
        this.total = productos.stream()
                .map(CarritoDetalle::getSubTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
