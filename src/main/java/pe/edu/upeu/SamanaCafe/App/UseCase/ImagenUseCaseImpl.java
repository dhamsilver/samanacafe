package pe.edu.upeu.SamanaCafe.App.UseCase;

import pe.edu.upeu.SamanaCafe.Domain.Model.Imagen;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Domain.Port.In.ImagenUseCase;
import pe.edu.upeu.SamanaCafe.Domain.Port.On.ImagenRepositoryPort;
import pe.edu.upeu.SamanaCafe.Domain.Port.On.ProductoRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ImagenUseCaseImpl implements ImagenUseCase {

    private final ImagenRepositoryPort imagenRepositoryPort;
    private final ProductoRepositoryPort productoRepositoryPort;

    public ImagenUseCaseImpl(ImagenRepositoryPort imagenRepositoryPort,
                             ProductoRepositoryPort productoRepositoryPort) {
        this.imagenRepositoryPort = imagenRepositoryPort;
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Imagen guardar(Imagen imagen, Long productoId) {
        // ✅ Validar que el producto exista
        Optional<Producto> productoOpt = productoRepositoryPort.findById(productoId);
        if (productoOpt.isEmpty()) {
            throw new IllegalArgumentException("El producto con id " + productoId + " no existe");
        }

        // ✅ Asociar producto al dominio
        imagen.setProducto(productoOpt.get());

        // ✅ Guardar la imagen
        return imagenRepositoryPort.guardar(imagen);
    }

    @Override
    public List<Imagen> listarPorProducto(Long productoId) {
        return imagenRepositoryPort.listarPorProducto(productoId);
    }

    @Override
    public boolean eliminarImagen(Long id) {
        return imagenRepositoryPort.findById(id)
                .map(img -> {
                    imagenRepositoryPort.deleteById(id);
                    return true;
                })
                .orElse(false);
    }
}
