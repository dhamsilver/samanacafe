package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller.Dto;

import java.math.BigDecimal;

public record CarritoDetalleDto() {

    public record CarritoDetalleRequest(
            Long productoId,
            Integer cantidad
    ) {}

    public record CarritoDetalleResponse(
            Long id,
            Long productoId,
            String productoNombre,
            Integer cantidad,
            BigDecimal subTotal
    ) {}
}
