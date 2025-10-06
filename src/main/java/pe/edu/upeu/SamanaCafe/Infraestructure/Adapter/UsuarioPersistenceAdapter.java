package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import pe.edu.upeu.SamanaCafe.Domain.Model.Usuario;
import pe.edu.upeu.SamanaCafe.Domain.Port.On.UsuarioRepositoryPort;
import pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Mapper.UsuarioMapper;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.Role;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioPersistenceAdapter implements UsuarioRepositoryPort {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioPersistenceAdapter(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario save(Usuario u) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setName(u.getName());
        usuarioEntity.setLastName(u.getLastName());
        usuarioEntity.setEmail(u.getEmail());
        usuarioEntity.setPassword(u.getPassword());
        usuarioEntity.setTelefono(u.getTelefono());
        usuarioEntity.setDireccion(u.getDireccion());
        usuarioEntity.setRegion(u.getRegion());
        usuarioEntity.setProvincia(u.getProvincia());
        usuarioEntity.setCiudad(u.getCiudad());
        usuarioEntity.setRole(u.getRole() != null ? u.getRole() : Role.CLIENTE);

        UsuarioEntity savedUsuario = usuarioRepository.save(usuarioEntity);

        return usuarioMapper.toDomainModel(savedUsuario);

    }

    @Override
    public Usuario update(Long id, Usuario u) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));

        usuarioEntity.setName(u.getName());
        usuarioEntity.setLastName(u.getLastName());
        usuarioEntity.setEmail(u.getEmail());
        usuarioEntity.setPassword(u.getPassword());
        usuarioEntity.setTelefono(u.getTelefono());
        usuarioEntity.setDireccion(u.getDireccion());
        usuarioEntity.setRegion(u.getRegion());
        usuarioEntity.setProvincia(u.getProvincia());
        usuarioEntity.setCiudad(u.getCiudad());
        usuarioEntity.setRole(u.getRole() != null ? u.getRole() : Role.CLIENTE);

        UsuarioEntity updateUsuario = usuarioRepository.save(usuarioEntity);

        return usuarioMapper.toDomainModel(updateUsuario);

    }

    @Override
    public Boolean deleteById(Long id) {
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Usuario> findAll() {
        List<UsuarioEntity> usuarioEntities = usuarioRepository.findAll();

        return usuarioMapper.toDomainModelList(usuarioEntities);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDomainModel);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .map(usuarioMapper::toDomainModel);
    }
}
