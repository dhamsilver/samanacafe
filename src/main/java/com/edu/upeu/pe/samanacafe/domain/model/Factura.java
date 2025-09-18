package com.edu.upeu.pe.samanacafe.domain.model;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.TipoComprabante;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Factura {

    private Long id;
    private Orden orden;
    private Pago pago;
    private String numeroFactura;
    private LocalDateTime fechaEmision;
    private BigDecimal montoTotal;
    private TipoComprabante tipo;

    public Factura() {}

    public Factura(Long id, Orden orden, Pago pago, String numeroFactura,
                   LocalDateTime fechaEmision, BigDecimal montoTotal, TipoComprabante tipo) {
        this.id = id;
        this.orden = orden;
        this.pago = pago;
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
        this.tipo = tipo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Orden getOrden() { return orden; }
    public void setOrden(Orden orden) { this.orden = orden; }

    public Pago getPago() { return pago; }
    public void setPago(Pago pago) { this.pago = pago; }

    public String getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }

    public LocalDateTime getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDateTime fechaEmision) { this.fechaEmision = fechaEmision; }

    public BigDecimal getMontoTotal() { return montoTotal; }
    public void setMontoTotal(BigDecimal montoTotal) { this.montoTotal = montoTotal; }

    public TipoComprabante getTipo() { return tipo; }
    public void setTipo(TipoComprabante tipo) { this.tipo = tipo; }
}

