package pe.edu.upeu.SamanaCafe.Domain.Port.In;

import pe.edu.upeu.SamanaCafe.Domain.Model.Venta;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;


import java.util.Optional;

public interface VentaUseCase {

    Venta crearVenta(Long usuarioId);

    Optional<Venta> agregarProducto(Long ventaId, Producto producto, int cantidad);

    Optional<Venta> eliminarProducto(Long ventaId, Long productoId);

    Optional<Venta> obtenerVentaPorUsuario(Long usuarioId);

    Optional<Venta> finalizarVenta(Long ventaId);
}
