package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter;

import org.springframework.stereotype.Component;
import pe.edu.upeu.SamanaCafe.Domain.Model.Venta;
import pe.edu.upeu.SamanaCafe.Domain.Model.CarritoDetalle;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Domain.Port.On.VentaRepositoryPort;
import pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Mapper.VentaMapper;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.VentaEntity;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.EstadoVenta;

import java.util.List;
import java.util.Optional;

@Component
public class VentaPersistenceAdapter implements VentaRepositoryPort {

    private final VentaRepository ventaRepository;
    private final VentaMapper ventaMapper;

    public VentaPersistenceAdapter(VentaRepository ventaRepository, VentaMapper ventaMapper) {
        this.ventaRepository = ventaRepository;
        this.ventaMapper = ventaMapper;
    }

    @Override
    public Venta save(Venta venta) {
        VentaEntity entity = ventaMapper.toEntiy(venta);

        if (entity.getProductos() != null) {
            for (var detalle : entity.getProductos()) {
                detalle.setCarrito(entity);
            }
        }

        entity = ventaRepository.save(entity);
        return ventaMapper.toDomainModel(entity);
    }

    @Override
    public Optional<Venta> findById(Long ventaId) {
        return ventaRepository.findById(ventaId)
                .map(entity -> {
                    Venta venta = ventaMapper.toDomainModel(entity);
                    fillDetalles(venta, entity);
                    return venta;
                });
    }

    @Override
    public Optional<Venta> findByUsuarioIdAndEstadoActivo(Long usuarioId) {
        return ventaRepository.findAll().stream()
                .filter(c -> c.getUsuario().getId().equals(usuarioId) && c.getEstado() == EstadoVenta.ACTIVO)
                .findFirst()
                .map(entity -> {
                    Venta venta = ventaMapper.toDomainModel(entity);
                    fillDetalles(venta, entity);
                    return venta;
                });
    }

    @Override
    public Venta update(Venta venta) {
        VentaEntity entity = ventaMapper.toEntiy(venta);

        if (entity.getProductos() != null) {
            for (var detalle : entity.getProductos()) {
                detalle.setCarrito(entity);
            }
        }

        entity = ventaRepository.save(entity);
        return ventaMapper.toDomainModel(entity);
    }

    @Override
    public Boolean deleteById(Long ventaId) {
        if (ventaRepository.existsById(ventaId)) {
            ventaRepository.deleteById(ventaId);
            return true;
        }
        return false;
    }

    private void fillDetalles(Venta venta, VentaEntity entity) {
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
                detalle.setVenta(venta);
                return detalle;
            }).toList();
            venta.setProductos(detalles);
        }
    }
}
