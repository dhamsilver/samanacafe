package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.CarritoEntity;

public interface CarritoRepository extends JpaRepository <CarritoEntity, Long> {
}
