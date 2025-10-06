package pe.edu.upeu.SamanaCafe.Infraestructure.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "venta")
public class VentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoVenta estado = EstadoVenta.ACTIVO;

    @Column(nullable = false)
    private BigDecimal total = BigDecimal.ZERO;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarritoDetalleEntity> productos;

    public VentaEntity() {
    }

    public VentaEntity(Long id, UsuarioEntity usuario, EstadoVenta estado, BigDecimal total, List<CarritoDetalleEntity> productos) {
        this.id = id;
        this.usuario = usuario;
        this.estado = estado;
        this.total = total;
        this.productos = productos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public EstadoVenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoVenta estado) {
        this.estado = estado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<CarritoDetalleEntity> getProductos() {
        return productos;
    }

    public void setProductos(List<CarritoDetalleEntity> productos) {
        this.productos = productos;
    }
}
