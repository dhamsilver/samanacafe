package com.edu.upeu.pe.samanacafe.domain.service;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.FacturaEntity;
import java.util.List;
import java.util.Optional;

public interface FacturaService {
    FacturaEntity create(FacturaEntity factura);
    Optional<FacturaEntity> findById(Long id);
    List<FacturaEntity> findAll();
    FacturaEntity update(Long id, FacturaEntity factura);
    void delete(Long id);
}


