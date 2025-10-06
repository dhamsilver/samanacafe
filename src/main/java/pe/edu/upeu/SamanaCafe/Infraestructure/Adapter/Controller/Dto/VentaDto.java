package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller.Dto;

import java.math.BigDecimal;
import java.util.List;

public record VentaDto() {

    public record VentaRequest(
            Long usuarioId,
            List<CarritoDetalleDto.CarritoDetalleRequest> productos
    ) {}

    public record VentaResponse(
            Long id,
            Long usuarioId,
            String estado,
            BigDecimal total,
            List<CarritoDetalleDto.CarritoDetalleResponse> productos
    ) {}
}
