package com.edu.upeu.pe.samanacafe.domain.service;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.OrdenDetalleEntity;
import java.util.List;
import java.util.Optional;

public interface OrdenDetalleService {
    OrdenDetalleEntity create(OrdenDetalleEntity detalle);
    Optional<OrdenDetalleEntity> findById(Long id);
    List<OrdenDetalleEntity> findAll();
    OrdenDetalleEntity update(Long id, OrdenDetalleEntity detalle);
    void delete(Long id);
}


