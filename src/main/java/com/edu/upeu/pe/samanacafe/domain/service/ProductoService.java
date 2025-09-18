package com.edu.upeu.pe.samanacafe.domain.service;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.ProductoEntity;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    ProductoEntity create(ProductoEntity producto);
    Optional<ProductoEntity> findById(Long id);
    List<ProductoEntity> findAll();
    ProductoEntity update(Long id, ProductoEntity producto);
    void delete(Long id);
}


