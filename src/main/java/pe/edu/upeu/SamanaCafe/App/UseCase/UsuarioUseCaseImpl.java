package pe.edu.upeu.SamanaCafe.App.UseCase;

import org.springframework.stereotype.Service;
import pe.edu.upeu.SamanaCafe.Domain.Model.Usuario;
import pe.edu.upeu.SamanaCafe.Domain.Port.In.UsuarioUseCase;
import pe.edu.upeu.SamanaCafe.Domain.Port.On.UsuarioRepositoryPort;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.Role;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario crearUsuario(Usuario u) {
        if (usuarioRepositoryPort.findByEmail(u.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email: " + u.getEmail() + " ya está en uso. " );
        }

        if (u.getRole() == null) {
            u.setRole(Role.CLIENTE);
        }

        return usuarioRepositoryPort.save(u);
    }

    @Override
    public Optional<Usuario> updateUsuario(Long id, Usuario u) {
        Optional<Usuario> email = usuarioRepositoryPort.findByEmail(u.getEmail());
        if (email.isPresent() && !email.get().getId().equals(id)) {
            // El email existe pero pertenece a otro usuario distinto
            throw new IllegalArgumentException("El email: " + u.getEmail() + " ya está en uso.");
        }

        return usuarioRepositoryPort.findById(id).map(existing -> {
            existing.setName(u.getName());
            existing.setLastName(u.getLastName());
            existing.setEmail(u.getEmail());
            existing.setPassword(u.getPassword());
            existing.setTelefono(u.getTelefono());
            existing.setDireccion(u.getDireccion());
            existing.setRegion(u.getRegion());
            existing.setProvincia(u.getProvincia());
            existing.setCiudad(u.getCiudad());
            existing.setRole(u.getRole() != null ? u.getRole() : existing.getRole());

            return usuarioRepositoryPort.update(id, existing);
        });
    }

    @Override
    public Boolean deleteUsuario(Long id) {
        return usuarioRepositoryPort.deleteById(id);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepositoryPort.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepositoryPort.findById(id);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepositoryPort.findByEmail(email);
    }
}
