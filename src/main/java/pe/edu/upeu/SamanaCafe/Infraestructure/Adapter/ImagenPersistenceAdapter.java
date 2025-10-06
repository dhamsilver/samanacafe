package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter;

import org.springframework.stereotype.Component;
import pe.edu.upeu.SamanaCafe.Domain.Model.Imagen;
import pe.edu.upeu.SamanaCafe.Domain.Port.On.ImagenRepositoryPort;
import pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Mapper.ImagenMapper;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.ImagenEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ImagenPersistenceAdapter implements ImagenRepositoryPort {

    private final ImagenRepository imagenRepository;

    public ImagenPersistenceAdapter(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

    @Override
    public Imagen guardar(Imagen imagen) {
        ImagenEntity entity = ImagenMapper.imagentoEntity(imagen);
        ImagenEntity savedEntity = imagenRepository.save(entity);
        return ImagenMapper.imagentoDomain(savedEntity);
    }

    @Override
    public List<Imagen> listarPorProducto(Long productoId) {
        return imagenRepository.findByProductoId(productoId)
                .stream()
                .map(ImagenMapper::imagentoDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Imagen> findById(Long id) {
        return imagenRepository.findById(id)
                .map(ImagenMapper::imagentoDomain);
    }

    @Override
    public void deleteById(Long id) {
        imagenRepository.deleteById(id);
    }
}
