package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller.Dto;

import java.math.BigDecimal;
import java.util.List;

public record CarritoDto() {

    public record CarritoRequest(
            Long usuarioId,
            List<CarritoDetalleDto.CarritoDetalleRequest> productos
    ) {}

    public record CarritoResponse(
            Long id,
            Long usuarioId,
            String estado,
            BigDecimal total,
            List<CarritoDetalleDto.CarritoDetalleResponse> productos
    ) {}
}
