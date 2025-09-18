package com.edu.upeu.pe.samanacafe.domain.service;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.CarritoDetalleEntity;
import java.util.List;
import java.util.Optional;

public interface CarritoDetalleService {
    CarritoDetalleEntity create(CarritoDetalleEntity detalle);
    Optional<CarritoDetalleEntity> findById(Long id);
    List<CarritoDetalleEntity> findAll();
    CarritoDetalleEntity update(Long id, CarritoDetalleEntity detalle);
    void delete(Long id);
}


