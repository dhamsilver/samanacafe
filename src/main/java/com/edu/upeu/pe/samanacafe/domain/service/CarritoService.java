package com.edu.upeu.pe.samanacafe.domain.service;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.CarritoEntity;
import java.util.List;
import java.util.Optional;

public interface CarritoService {
    CarritoEntity create(CarritoEntity carrito);
    Optional<CarritoEntity> findById(Long id);
    List<CarritoEntity> findAll();
    CarritoEntity update(Long id, CarritoEntity carrito);
    void delete(Long id);
}


