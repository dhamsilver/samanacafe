package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.SamanaCafe.Domain.Model.Imagen;
import pe.edu.upeu.SamanaCafe.Domain.Port.In.ImagenUseCase;
import pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller.Dto.ImagenDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/imagenes")
public class ImagenController {

    private final ImagenUseCase imagenUseCase;

    public ImagenController(ImagenUseCase imagenUseCase) {
        this.imagenUseCase = imagenUseCase;
    }

    @GetMapping("/producto/{productoId}")
    public ResponseEntity<List<ImagenDto.ImagenResponse>> getByProducto(@PathVariable Long productoId) {
        List<ImagenDto.ImagenResponse> imagenes = imagenUseCase.listarPorProducto(productoId)
                .stream()
                .map(this::mapToImagenResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(imagenes);
    }

    @PostMapping("/producto/{productoId}")
    public ResponseEntity<ImagenDto.ImagenResponse> createImagen(
            @PathVariable Long productoId,
            @RequestBody ImagenDto.ImagenRequest imagenRequest) {

        Imagen imagenToCreate = new Imagen();
        imagenToCreate.setNombreArchivo(imagenRequest.nombreArchivo());
        imagenToCreate.setUrl(imagenRequest.url());

        Imagen createdImagen = imagenUseCase.guardar(imagenToCreate, productoId);
        return new ResponseEntity<>(mapToImagenResponse(createdImagen), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImagen(@PathVariable Long id) {
        if (imagenUseCase.eliminarImagen(id)) {
            return ResponseEntity.noContent().build(); // HTTP 204
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404
        }
    }



    private ImagenDto.ImagenResponse mapToImagenResponse(Imagen imagen) {
        return new ImagenDto.ImagenResponse(
                imagen.getId(),
                imagen.getNombreArchivo(),
                imagen.getUrl()
        );
    }
}

