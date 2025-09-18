package com.edu.upeu.pe.samanacafe.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carritos")
public class CarritoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private CarritoEstado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarritoDetalleEntity> detalles = new ArrayList<>();

    public CarritoEntity() {
        this.fechaCreacion = LocalDateTime.now();
        this.estado = CarritoEstado.ABIERTO;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public CarritoEstado getEstado() { return estado; }
    public void setEstado(CarritoEstado estado) { this.estado = estado; }

    public UsuarioEntity getUsuario() { return usuario; }
    public void setUsuario(UsuarioEntity usuario) { this.usuario = usuario; }

    public List<CarritoDetalleEntity> getDetalles() { return detalles; }
    public void setDetalles(List<CarritoDetalleEntity> detalles) { this.detalles = detalles; }
}
