package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.SamanaCafe.Domain.Model.Usuario;
import pe.edu.upeu.SamanaCafe.Domain.Port.In.UsuarioUseCase;
import pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller.Dto.UsuarioDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController{

    private final UsuarioUseCase usuarioUseCase;

    public UsuarioController(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto.UsuarioResponse>> getAllUsuarios(){
        List<UsuarioDto.UsuarioResponse> usuarios = usuarioUseCase.getAllUsuarios()
                .stream()
                .map(this::mapToUsuarioResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto.UsuarioResponse> createUsuario(@RequestBody UsuarioDto.UsuarioRequest usuarioRequest) {
        Usuario usuarioToCreate = new Usuario();
        usuarioToCreate.setName(usuarioRequest.name());
        usuarioToCreate.setLastName(usuarioRequest.lastName());
        usuarioToCreate.setEmail(usuarioRequest.email());
        usuarioToCreate.setPassword(usuarioRequest.password());
        usuarioToCreate.setTelefono(usuarioRequest.telefono());
        usuarioToCreate.setDireccion(usuarioRequest.direccion());
        usuarioToCreate.setRegion(usuarioRequest.region());
        usuarioToCreate.setProvincia(usuarioRequest.provincia());
        usuarioToCreate.setCiudad(usuarioRequest.ciudad());

        Usuario createUsuario = usuarioUseCase.crearUsuario(usuarioToCreate);
        return new ResponseEntity<>(mapToUsuarioResponse(createUsuario), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto.UsuarioResponse> updateUsuario
            (@PathVariable Long id, @RequestBody UsuarioDto.UsuarioRequest usuarioRequest) {
        Usuario usuarioToUpdate = new Usuario();
        usuarioToUpdate.setName(usuarioRequest.name());
        usuarioToUpdate.setLastName(usuarioRequest.lastName());
        usuarioToUpdate.setEmail(usuarioRequest.email());
        usuarioToUpdate.setPassword(usuarioRequest.password());
        usuarioToUpdate.setTelefono(usuarioRequest.telefono());
        usuarioToUpdate.setDireccion(usuarioRequest.direccion());
        usuarioToUpdate.setRegion(usuarioRequest.region());
        usuarioToUpdate.setProvincia(usuarioRequest.provincia());
        usuarioToUpdate.setCiudad(usuarioRequest.ciudad());


        return usuarioUseCase.updateUsuario(id, usuarioToUpdate)
                .map(usuario -> ResponseEntity.ok(mapToUsuarioResponse(usuario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        if(usuarioUseCase.deleteUsuario(id)){
            return ResponseEntity.noContent().build(); //HTTP 204
        }else{
            return ResponseEntity.notFound().build(); //HTTP 404
        }
    }

    //metodo de ayuda al mapping
    private UsuarioDto.UsuarioResponse mapToUsuarioResponse(Usuario usuario) {
        return new UsuarioDto.UsuarioResponse(
                usuario.getId(),
                usuario.getName(),
                usuario.getLastName(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getDireccion(),
                usuario.getRegion(),
                usuario.getProvincia(),
                usuario.getCiudad(),
                usuario.getRole()
        );
    }
}
