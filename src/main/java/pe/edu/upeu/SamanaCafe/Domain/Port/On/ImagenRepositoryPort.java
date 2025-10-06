package pe.edu.upeu.SamanaCafe.Domain.Port.On;

import pe.edu.upeu.SamanaCafe.Domain.Model.Imagen;

import java.util.List;
import java.util.Optional;

public interface ImagenRepositoryPort {

    Imagen guardar(Imagen imagen);
    List<Imagen> listarPorProducto(Long productoId);
    Optional<Imagen> findById(Long id);
    void deleteById(Long id);

}
