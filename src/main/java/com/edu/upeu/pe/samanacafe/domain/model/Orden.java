package com.edu.upeu.pe.samanacafe.domain.model;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.EstadoOrden;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Orden {

    private Long id;
    private LocalDateTime fechaCreacion;
    private EstadoOrden estado; // PENDIENTE, PAGADA, CANCELADA

    private Carrito carrito;
    private List<OrdenDetalle> detalles = new ArrayList<>();

    public Orden() {
        this.fechaCreacion = LocalDateTime.now();
        this.estado = EstadoOrden.PENDIENTE;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public EstadoOrden getEstado() { return estado; }
    public void setEstado(EstadoOrden estado) { this.estado = estado; }

    public Carrito getCarrito() { return carrito; }
    public void setCarrito(Carrito carrito) { this.carrito = carrito; }

    public List<OrdenDetalle> getDetalles() { return detalles; }
    public void setDetalles(List<OrdenDetalle> detalles) { this.detalles = detalles; }
}

