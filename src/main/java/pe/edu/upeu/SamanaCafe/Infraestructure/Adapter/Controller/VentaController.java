package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.SamanaCafe.Domain.Model.Venta;
import pe.edu.upeu.SamanaCafe.Domain.Model.CarritoDetalle;
import pe.edu.upeu.SamanaCafe.Domain.Model.Producto;
import pe.edu.upeu.SamanaCafe.Domain.Port.In.VentaUseCase;
import pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller.Dto.VentaDto;
import pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller.Dto.CarritoDetalleDto;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/ventas")
public class VentaController {

    private final VentaUseCase ventaUseCase;

    public VentaController(VentaUseCase ventaUseCase) {
        this.ventaUseCase = ventaUseCase;
    }

    // Crear carrito vacío para un usuario
    @PostMapping("/crear/{usuarioId}")
    public ResponseEntity<VentaDto.VentaResponse> crearVenta(@PathVariable Long usuarioId) {
        Venta venta = ventaUseCase.crearVenta(usuarioId);
        return new ResponseEntity<>(mapToVentaResponse(venta), HttpStatus.CREATED);
    }

    // Obtener carrito activo de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<VentaDto.VentaResponse> obtenerVentaPorUsuario(@PathVariable Long usuarioId) {
        return ventaUseCase.obtenerVentaPorUsuario(usuarioId)
                .map(carrito -> ResponseEntity.ok(mapToVentaResponse(carrito)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Agregar producto a un carrito
    @PostMapping("/{ventaId}/agregar")
    public ResponseEntity<VentaDto.VentaResponse> agregarProducto(
            @PathVariable Long ventaId,
            @RequestBody CarritoDetalleDto.CarritoDetalleRequest request
    ) {
        Producto producto = new Producto();
        producto.setId(request.productoId());

        return ventaUseCase.agregarProducto(ventaId, producto, request.cantidad())
                .map(venta -> ResponseEntity.ok(mapToVentaResponse(venta)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar producto de un carrito
    @DeleteMapping("/{ventaId}/producto/{productoId}")
    public ResponseEntity<VentaDto.VentaResponse> eliminarProducto(
            @PathVariable Long ventaId,
            @PathVariable Long productoId
    ) {
        return ventaUseCase.eliminarProducto(ventaId, productoId)
                .map(venta -> ResponseEntity.ok(mapToVentaResponse(venta)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Finalizar carrito (ej: pasar a pedido)
    @PostMapping("/{ventaId}/finalizar")
    public ResponseEntity<VentaDto.VentaResponse> finalizarVenta(@PathVariable Long ventaId) {
        return ventaUseCase.finalizarVenta(ventaId)
                .map(venta -> ResponseEntity.ok(mapToVentaResponse(venta)))
                .orElse(ResponseEntity.notFound().build());
    }

    // ---- Métodos privados de ayuda ----

    private VentaDto.VentaResponse mapToVentaResponse(Venta venta) {
        return new VentaDto.VentaResponse(
                venta.getId(),
                venta.getUsuario().getId(),
                venta.getEstado().name(),
                venta.getTotal(),
                venta.getProductos().stream()
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
