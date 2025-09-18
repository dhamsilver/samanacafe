package com.edu.upeu.pe.samanacafe.domain.service;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.DireccionEntity;
import java.util.List;
import java.util.Optional;

public interface DireccionService {
    DireccionEntity create(DireccionEntity direccion);
    Optional<DireccionEntity> findById(Long id);
    List<DireccionEntity> findAll();
    DireccionEntity update(Long id, DireccionEntity direccion);
    void delete(Long id);
}


