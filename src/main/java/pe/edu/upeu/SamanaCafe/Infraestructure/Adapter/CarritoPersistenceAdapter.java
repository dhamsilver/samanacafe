package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter;

import org.springframework.stereotype.Component;
import pe.edu.upeu.SamanaCafe.Domain.Model.Carrito;
import pe.edu.upeu.SamanaCafe.Domain.Model.CarritoDetalle;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Domain.Port.On.CarritoRepositoryPort;
import pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Mapper.CarritoMapper;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.CarritoEntity;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.EstadoCarrito;

import java.util.List;
import java.util.Optional;

@Component
public class CarritoPersistenceAdapter implements CarritoRepositoryPort {

    private final CarritoRepository carritoRepository;
    private final CarritoMapper carritoMapper;

    public CarritoPersistenceAdapter(CarritoRepository carritoRepository, CarritoMapper carritoMapper) {
        this.carritoRepository = carritoRepository;
        this.carritoMapper = carritoMapper;
    }

    @Override
    public Carrito save(Carrito carrito) {
        CarritoEntity entity = carritoMapper.toEntiy(carrito);

        if (entity.getProductos() != null) {
            for (var detalle : entity.getProductos()) {
                detalle.setCarrito(entity);
            }
        }

        entity = carritoRepository.save(entity);
        return carritoMapper.toDomainModel(entity);
    }

    @Override
    public Optional<Carrito> findById(Long carritoId) {
        return carritoRepository.findById(carritoId)
                .map(entity -> {
                    Carrito carrito = carritoMapper.toDomainModel(entity);
                    fillDetalles(carrito, entity);
                    return carrito;
                });
    }

    @Override
    public Optional<Carrito> findByUsuarioIdAndEstadoActivo(Long usuarioId) {
        return carritoRepository.findAll().stream()
                .filter(c -> c.getUsuario().getId().equals(usuarioId) && c.getEstado() == EstadoCarrito.ACTIVO)
                .findFirst()
                .map(entity -> {
                    Carrito carrito = carritoMapper.toDomainModel(entity);
                    fillDetalles(carrito, entity);
                    return carrito;
                });
    }

    @Override
    public Carrito update(Carrito carrito) {
        CarritoEntity entity = carritoMapper.toEntiy(carrito);

        if (entity.getProductos() != null) {
            for (var detalle : entity.getProductos()) {
                detalle.setCarrito(entity);
            }
        }

        entity = carritoRepository.save(entity);
        return carritoMapper.toDomainModel(entity);
    }

    @Override
    public Boolean deleteById(Long carritoId) {
        if (carritoRepository.existsById(carritoId)) {
            carritoRepository.deleteById(carritoId);
            return true;
        }
        return false;
    }

    private void fillDetalles(Carrito carrito, CarritoEntity entity) {
        if (entity.getProductos() != null) {
            List<CarritoDetalle> detalles = entity.getProductos().stream().map(detEntity -> {
                CarritoDetalle detalle = new CarritoDetalle();
                detalle.setId(detEntity.getId());
                detalle.setCantidad(detEntity.getCantidad());
                detalle.setSubTotal(detEntity.getSubtotal());
                if (detEntity.getProducto() != null) {
                    detalle.setProducto(new Producto(
                            detEntity.getProducto().getId(),
                            detEntity.getProducto().getName(), // 🔹 corregido (era getNombre)
                            detEntity.getProducto().getPrecio()
                    ));
                }
                detalle.setCarrito(carrito);
                return detalle;
            }).toList();
            carrito.setProductos(detalles);
        }
    }
}
