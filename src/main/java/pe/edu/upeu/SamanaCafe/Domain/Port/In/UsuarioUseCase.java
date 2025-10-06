package pe.edu.upeu.SamanaCafe.Domain.Port.In;

import pe.edu.upeu.SamanaCafe.Domain.Model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioUseCase {

    Usuario crearUsuario(Usuario u);

    Optional<Usuario> updateUsuario (Long id, Usuario u);

    Boolean deleteUsuario(Long id);

    List<Usuario> getAllUsuarios();

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByEmail(String email);

}
