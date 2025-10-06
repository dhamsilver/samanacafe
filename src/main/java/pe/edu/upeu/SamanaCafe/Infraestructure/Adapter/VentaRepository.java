package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.VentaEntity;

public interface VentaRepository extends JpaRepository <VentaEntity, Long> {
}
