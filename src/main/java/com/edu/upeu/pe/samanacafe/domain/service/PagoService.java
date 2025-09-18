package com.edu.upeu.pe.samanacafe.domain.service;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.PagoEntity;
import java.util.List;
import java.util.Optional;

public interface PagoService {
    PagoEntity create(PagoEntity pago);
    Optional<PagoEntity> findById(Long id);
    List<PagoEntity> findAll();
    PagoEntity update(Long id, PagoEntity pago);
    void delete(Long id);
}


