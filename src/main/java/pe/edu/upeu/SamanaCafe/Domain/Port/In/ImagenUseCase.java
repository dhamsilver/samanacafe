package pe.edu.upeu.SamanaCafe.Domain.Port.In;

import pe.edu.upeu.SamanaCafe.Domain.Model.Imagen;
import java.util.List;

public interface ImagenUseCase {
    Imagen guardar(Imagen imagen, Long productoId);
    List<Imagen> listarPorProducto(Long productoId);
    boolean eliminarImagen(Long id);
}