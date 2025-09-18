package com.edu.upeu.pe.samanacafe.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordenes")
public class OrdenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private EstadoOrden estado; // PENDIENTE, PAGADA, CANCELADA

    @OneToOne
    @JoinColumn(name = "carrito_id", nullable = false)
    private CarritoEntity carrito;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenDetalleEntity> detalles = new ArrayList<>();

    public OrdenEntity() {
        this.fechaCreacion = LocalDateTime.now();
        this.estado = EstadoOrden.PENDIENTE;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public EstadoOrden getEstado() { return estado; }
    public void setEstado(EstadoOrden estado) { this.estado = estado; }

    public CarritoEntity getCarrito() { return carrito; }
    public void setCarrito(CarritoEntity carrito) { this.carrito = carrito; }

    public List<OrdenDetalleEntity> getDetalles() { return detalles; }
    public void setDetalles(List<OrdenDetalleEntity> detalles) { this.detalles = detalles; }
}

