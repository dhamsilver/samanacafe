package pe.edu.upeu.SamanaCafe.Domain.Port.In;

import pe.edu.upeu.SamanaCafe.Domain.Model.Carrito;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;


import java.util.Optional;

public interface CarritoUseCase {

    Carrito crearCarrito(Long usuarioId);

    Optional<Carrito> agregarProducto(Long carritoId, Producto producto, int cantidad);

    Optional<Carrito> eliminarProducto(Long carritoId, Long productoId);

    Optional<Carrito> obtenerCarritoPorUsuario(Long usuarioId);

    Optional<Carrito> finalizarCarrito(Long carritoId);
}
