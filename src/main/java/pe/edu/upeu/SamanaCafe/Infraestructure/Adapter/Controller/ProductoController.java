package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Domain.Port.In.ProductoUseCase;
import pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller.Dto.ProductoDto;
import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.CategoriaProducto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/productos")
public class ProductoController{

    private final ProductoUseCase productoUseCase;

    public ProductoController(ProductoUseCase productoUseCase) {
        this.productoUseCase = productoUseCase;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDto.ProductoResponse>> getAllProductos() {
        List<ProductoDto.ProductoResponse> productos = productoUseCase.getAllProductos()
                .stream()
                .map(this::mapToProductoResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProductoDto.ProductoResponse>> getByCategoria(@PathVariable CategoriaProducto categoria) {
        List<ProductoDto.ProductoResponse> productos = productoUseCase.findByCategoria(categoria)
                .stream()
                .map(this::mapToProductoResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<ProductoDto.ProductoResponse> createProducto(
            @RequestBody ProductoDto.ProductoRequest productoRequest) {

        Producto productoToCreate = new Producto();
        productoToCreate.setName(productoRequest.name());
        productoToCreate.setDescripcion(productoRequest.descripcion());
        productoToCreate.setCategoriaProducto(productoRequest.categoriaProducto());
        productoToCreate.setPrecio(productoRequest.precio());

        Producto createdProducto = productoUseCase.crearProducto(productoToCreate);
        return new ResponseEntity<>(mapToProductoResponse(createdProducto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto.ProductoResponse> updateProducto(
            @PathVariable Long id,
            @RequestBody ProductoDto.ProductoRequest productoRequest) {

        Producto productoToUpdate = new Producto();
        productoToUpdate.setName(productoRequest.name());
        productoToUpdate.setDescripcion(productoRequest.descripcion());
        productoToUpdate.setCategoriaProducto(productoRequest.categoriaProducto());
        productoToUpdate.setPrecio(productoRequest.precio());

        return productoUseCase.updateProducto(id, productoToUpdate)
                .map(producto -> ResponseEntity.ok(mapToProductoResponse(producto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        if (productoUseCase.deleteProducto(id)) {
            return ResponseEntity.noContent().build(); // HTTP 204
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404
        }
    }

    // método de ayuda para mapear
    private ProductoDto.ProductoResponse mapToProductoResponse(Producto producto) {
        return new ProductoDto.ProductoResponse(
                producto.getId(),
                producto.getName(),
                producto.getDescripcion(),
                producto.getCategoriaProducto(),
                producto.getPrecio()
        );
    }
}
