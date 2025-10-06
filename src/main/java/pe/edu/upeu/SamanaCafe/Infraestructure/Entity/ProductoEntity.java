package pe.edu.upeu.SamanaCafe.Infraestructure.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaProducto categoriaProducto;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenEntity> imagenes = new ArrayList<>();


    public ProductoEntity() {
    }

    public ProductoEntity(Long id, String name, String descripcion, CategoriaProducto categoriaProducto, BigDecimal precio, List<ImagenEntity> imagenes) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.categoriaProducto = categoriaProducto;
        this.precio = precio;
        this.imagenes = imagenes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public List<ImagenEntity> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenEntity> imagenes) {
        this.imagenes = imagenes;
    }
}
