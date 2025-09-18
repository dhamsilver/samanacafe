package com.edu.upeu.pe.samanacafe.infrastructure.service;

import com.edu.upeu.pe.samanacafe.domain.service.FacturaService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.FacturaEntity;
import com.edu.upeu.pe.samanacafe.infrastructure.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public FacturaEntity create(FacturaEntity factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public Optional<FacturaEntity> findById(Long id) {
        return facturaRepository.findById(id);
    }

    @Override
    public List<FacturaEntity> findAll() {
        return facturaRepository.findAll();
    }

    @Override
    public FacturaEntity update(Long id, FacturaEntity factura) {
        factura.setId(id);
        return facturaRepository.save(factura);
    }

    @Override
    public void delete(Long id) {
        facturaRepository.deleteById(id);
    }
}


