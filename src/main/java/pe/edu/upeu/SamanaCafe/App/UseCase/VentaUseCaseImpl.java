package pe.edu.upeu.SamanaCafe.App.UseCase;

import org.springframework.stereotype.Service;
import pe.edu.upeu.SamanaCafe.Domain.Model.Venta;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Domain.Model.Usuario;
import pe.edu.upeu.SamanaCafe.Domain.Port.In.VentaUseCase;
import pe.edu.upeu.SamanaCafe.Domain.Port.On.VentaRepositoryPort;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.EstadoVenta;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class VentaUseCaseImpl implements VentaUseCase {

    private final VentaRepositoryPort ventaRepositoryPort;

    public VentaUseCaseImpl(VentaRepositoryPort ventaRepositoryPort) {
        this.ventaRepositoryPort = ventaRepositoryPort;
    }

    @Override
    public Venta crearVenta(Long usuarioId)
    {
        Venta venta = new Venta();

        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        venta.setUsuario(usuario);

        venta.setEstado(EstadoVenta.ACTIVO);
        venta.setTotal(BigDecimal.ZERO);

        return ventaRepositoryPort.save(venta);
    }

    @Override
    public Optional<Venta> agregarProducto(Long ventaId, Producto producto, int cantidad) {
        return ventaRepositoryPort.findById(ventaId).map(carrito -> {
            carrito.agregarProducto(producto, cantidad);
            return ventaRepositoryPort.update(carrito);
        });
    }

    @Override
    public Optional<Venta> eliminarProducto(Long ventaId, Long productoId) {
        return ventaRepositoryPort.findById(ventaId).map(carrito -> {
            carrito.eliminarProducto(productoId);
            return ventaRepositoryPort.update(carrito);
        });
    }

    @Override
    public Optional<Venta> obtenerVentaPorUsuario(Long usuarioId) {
        return ventaRepositoryPort.findByUsuarioIdAndEstadoActivo(usuarioId);
    }

    @Override
    public Optional<Venta> finalizarVenta(Long ventaId) {
        return ventaRepositoryPort.findById(ventaId).map(carrito -> {
            carrito.setEstado(EstadoVenta.CANCELADO);
            return ventaRepositoryPort.update(carrito);
        });
    }
}
