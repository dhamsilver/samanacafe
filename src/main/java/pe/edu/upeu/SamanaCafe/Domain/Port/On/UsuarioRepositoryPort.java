package pe.edu.upeu.SamanaCafe.Domain.Port.On;

import pe.edu.upeu.SamanaCafe.Domain.Model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryPort {

    Usuario save(Usuario u);

    Usuario update(Long id, Usuario u);

    Boolean deleteById(Long id);

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByEmail(String email);

}
