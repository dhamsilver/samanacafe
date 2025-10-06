package pe.edu.upeu.SamanaCafe.App.UseCase;

import org.springframework.stereotype.Service;
import pe.edu.upeu.SamanaCafe.Domain.Model.Carrito;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Domain.Model.Usuario;
import pe.edu.upeu.SamanaCafe.Domain.Port.In.CarritoUseCase;
import pe.edu.upeu.SamanaCafe.Domain.Port.On.CarritoRepositoryPort;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.EstadoCarrito;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CarritoUseCaseImpl implements CarritoUseCase {

    private final CarritoRepositoryPort carritoRepositoryPort;

    public CarritoUseCaseImpl(CarritoRepositoryPort carritoRepositoryPort) {
        this.carritoRepositoryPort = carritoRepositoryPort;
    }

    @Override
    public Carrito crearCarrito(Long usuarioId)
    {
        Carrito carrito = new Carrito();

        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        carrito.setUsuario(usuario);

        carrito.setEstado(EstadoCarrito.ACTIVO);
        carrito.setTotal(BigDecimal.ZERO);

        return carritoRepositoryPort.save(carrito);
    }

    @Override
    public Optional<Carrito> agregarProducto(Long carritoId, Producto producto, int cantidad) {
        return carritoRepositoryPort.findById(carritoId).map(carrito -> {
            carrito.agregarProducto(producto, cantidad);
            return carritoRepositoryPort.update(carrito);
        });
    }

    @Override
    public Optional<Carrito> eliminarProducto(Long carritoId, Long productoId) {
        return carritoRepositoryPort.findById(carritoId).map(carrito -> {
            carrito.eliminarProducto(productoId);
            return carritoRepositoryPort.update(carrito);
        });
    }

    @Override
    public Optional<Carrito> obtenerCarritoPorUsuario(Long usuarioId) {
        return carritoRepositoryPort.findByUsuarioIdAndEstadoActivo(usuarioId);
    }

    @Override
    public Optional<Carrito> finalizarCarrito(Long carritoId) {
        return carritoRepositoryPort.findById(carritoId).map(carrito -> {
            carrito.setEstado(EstadoCarrito.CANCELADO);
            return carritoRepositoryPort.update(carrito);
        });
    }
}
