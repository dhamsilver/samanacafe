package com.edu.upeu.pe.samanacafe.infrastructure.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
public class FacturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_id", nullable = false, unique = true)
    private OrdenEntity orden;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pago_id", nullable = false, unique = true)
    private PagoEntity pago;

    @Column(nullable = false, length = 20, unique = true)
    private String numeroFactura; // Ejemplo: F001-000123

    @Column(nullable = false)
    private LocalDateTime fechaEmision;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montoTotal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoComprabante tipo; // FACTURA o BOLETA

    public FacturaEntity() {}

    public FacturaEntity(Long id, OrdenEntity orden, PagoEntity pago,
                         String numeroFactura, LocalDateTime fechaEmision,
                         BigDecimal montoTotal, TipoComprabante tipo) {
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

    public OrdenEntity getOrden() { return orden; }
    public void setOrden(OrdenEntity orden) { this.orden = orden; }

    public PagoEntity getPago() { return pago; }
    public void setPago(PagoEntity pago) { this.pago = pago; }

    public String getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }

    public LocalDateTime getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDateTime fechaEmision) { this.fechaEmision = fechaEmision; }

    public BigDecimal getMontoTotal() { return montoTotal; }
    public void setMontoTotal(BigDecimal montoTotal) { this.montoTotal = montoTotal; }

    public TipoComprabante getTipo() { return tipo; }
    public void setTipo(TipoComprabante tipo) { this.tipo = tipo; }
}

