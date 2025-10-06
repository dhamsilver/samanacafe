package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.SamanaCafe.Domain.Model.Carrito;
import pe.edu.upeu.SamanaCafe.Domain.Model.CarritoDetalle;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Domain.Port.In.CarritoUseCase;
import pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller.Dto.CarritoDto;
import pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller.Dto.CarritoDetalleDto;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/carritos")
public class CarritoController {

    private final CarritoUseCase carritoUseCase;

    public CarritoController(CarritoUseCase carritoUseCase) {
        this.carritoUseCase = carritoUseCase;
    }

    // Crear carrito vacío para un usuario
    @PostMapping("/crear/{usuarioId}")
    public ResponseEntity<CarritoDto.CarritoResponse> crearCarrito(@PathVariable Long usuarioId) {
        Carrito carrito = carritoUseCase.crearCarrito(usuarioId);
        return new ResponseEntity<>(mapToCarritoResponse(carrito), HttpStatus.CREATED);
    }

    // Obtener carrito activo de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<CarritoDto.CarritoResponse> obtenerCarritoPorUsuario(@PathVariable Long usuarioId) {
        return carritoUseCase.obtenerCarritoPorUsuario(usuarioId)
                .map(carrito -> ResponseEntity.ok(mapToCarritoResponse(carrito)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Agregar producto a un carrito
    @PostMapping("/{carritoId}/agregar")
    public ResponseEntity<CarritoDto.CarritoResponse> agregarProducto(
            @PathVariable Long carritoId,
            @RequestBody CarritoDetalleDto.CarritoDetalleRequest request
    ) {
        Producto producto = new Producto();
        producto.setId(request.productoId());

        return carritoUseCase.agregarProducto(carritoId, producto, request.cantidad())
                .map(carrito -> ResponseEntity.ok(mapToCarritoResponse(carrito)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar producto de un carrito
    @DeleteMapping("/{carritoId}/producto/{productoId}")
    public ResponseEntity<CarritoDto.CarritoResponse> eliminarProducto(
            @PathVariable Long carritoId,
            @PathVariable Long productoId
    ) {
        return carritoUseCase.eliminarProducto(carritoId, productoId)
                .map(carrito -> ResponseEntity.ok(mapToCarritoResponse(carrito)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Finalizar carrito (ej: pasar a pedido)
    @PostMapping("/{carritoId}/finalizar")
    public ResponseEntity<CarritoDto.CarritoResponse> finalizarCarrito(@PathVariable Long carritoId) {
        return carritoUseCase.finalizarCarrito(carritoId)
                .map(carrito -> ResponseEntity.ok(mapToCarritoResponse(carrito)))
                .orElse(ResponseEntity.notFound().build());
    }

    // ---- Métodos privados de ayuda ----

    private CarritoDto.CarritoResponse mapToCarritoResponse(Carrito carrito) {
        return new CarritoDto.CarritoResponse(
                carrito.getId(),
                carrito.getUsuario().getId(),
                carrito.getEstado().name(),
                carrito.getTotal(),
                carrito.getProductos().stream()
                        .map(this::mapToCarritoDetalleResponse)
                        .collect(Collectors.toList())
        );
    }

    private CarritoDetalleDto.CarritoDetalleResponse mapToCarritoDetalleResponse(CarritoDetalle detalle) {
        return new CarritoDetalleDto.CarritoDetalleResponse(
                detalle.getId(),
                detalle.getProducto().getId(),
                detalle.getProducto().getName(),
                detalle.getCantidad(),
                detalle.getSubTotal()
        );
    }
}
