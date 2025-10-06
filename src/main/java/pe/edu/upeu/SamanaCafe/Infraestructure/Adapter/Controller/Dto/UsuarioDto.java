package pe.edu.upeu.SamanaCafe.Infraestructure.Adapter.Controller.Dto;


import pe.edu.upeu.SamanaCafe.Infraestructure.Entity.Role;

public record UsuarioDto() {

    public record UsuarioRequest(String name, String lastName, String email, String password, String telefono, String direccion, String region, String provincia, String ciudad){}

    public record UsuarioResponse(Long id, String name, String lastName, String email, String telefono, String direccion, String region, String provincia, String ciudad, Role role){}
}
