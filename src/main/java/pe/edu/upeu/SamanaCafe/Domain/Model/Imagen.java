package pe.edu.upeu.SamanaCafe.Domain.Model;

public class Imagen {
    private Long id;
    private String nombreArchivo;
    private String url;
    private Producto producto; // ✅ relación con producto en el dominio

    public Imagen() {}

    public Imagen(Long id, String nombreArchivo, String url, Producto producto) {
        this.id = id;
        this.nombreArchivo = nombreArchivo;
        this.url = url;
        this.producto = producto;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
