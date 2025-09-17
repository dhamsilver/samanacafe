package com.edu.upeu.pe.samanacafe.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ventas")
public class VentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
