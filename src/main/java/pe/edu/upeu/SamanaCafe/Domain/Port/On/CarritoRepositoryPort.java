package pe.edu.upeu.SamanaCafe.Domain.Port.On;

import pe.edu.upeu.SamanaCafe.Domain.Model.Carrito;

import java.util.Optional;

public interface CarritoRepositoryPort {


    Carrito save(Carrito carrito);

    Optional<Carrito> findById(Long carritoId);

    Optional<Carrito> findByUsuarioIdAndEstadoActivo(Long usuarioId);

    Carrito update(Carrito carrito);

    Boolean deleteById(Long carritoId);
}
