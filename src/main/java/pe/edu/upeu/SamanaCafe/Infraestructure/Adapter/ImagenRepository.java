package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.ImagenEntity;

import java.util.List;

public interface ImagenRepository extends JpaRepository<ImagenEntity, Long> {
    List<ImagenEntity> findByProductoId(Long productoId);
}
