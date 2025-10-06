package pe.edu.upeu.SamanaCafe.Domain.Port.On;

import pe.edu.upeu.SamanaCafe.Domain.Model.Venta;

import java.util.Optional;

public interface VentaRepositoryPort {


    Venta save(Venta venta);

    Optional<Venta> findById(Long ventaId);

    Optional<Venta> findByUsuarioIdAndEstadoActivo(Long usuarioId);

    Venta update(Venta venta);

    Boolean deleteById(Long ventaId);
}
