package com.edu.upeu.pe.samanacafe.domain.service;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.OrdenEntity;
import java.util.List;
import java.util.Optional;

public interface OrdenService {
    OrdenEntity create(OrdenEntity orden);
    Optional<OrdenEntity> findById(Long id);
    List<OrdenEntity> findAll();
    OrdenEntity update(Long id, OrdenEntity orden);
    void delete(Long id);
}


