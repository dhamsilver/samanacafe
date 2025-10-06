package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller.Dto;

public record ImagenDto() {

    public record ImagenRequest(
            String nombreArchivo,
            String url
    ) {}

    public record ImagenResponse(
            Long id,
            String nombreArchivo,
            String url
    ) {}
}
