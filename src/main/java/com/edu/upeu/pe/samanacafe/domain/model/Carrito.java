package com.edu.upeu.pe.samanacafe.domain.model;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.CarritoEstado;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private Long id;
    private LocalDateTime fechaCreacion;
    private CarritoEstado estado;
    private Usuario usuario;
    private List<CarritoDetalle> detalles = new ArrayList<>();

    public Carrito() {
        this.fechaCreacion = LocalDateTime.now();
        this.estado = CarritoEstado.ABIERTO;
    }

    // getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public CarritoEstado getEstado() { return estado; }
    public void setEstado(CarritoEstado estado) { this.estado = estado; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<CarritoDetalle> getDetalles() { return detalles; }
    public void setDetalles(List<CarritoDetalle> detalles) { this.detalles = detalles; }
}

