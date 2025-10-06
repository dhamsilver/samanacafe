package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.SamanaCafe.Domain.Model.Usuario;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.UsuarioEntity;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByEmail(String email);


}
