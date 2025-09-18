package com.edu.upeu.pe.samanacafe.infrastructure.service;

import com.edu.upeu.pe.samanacafe.domain.service.OrdenDetalleService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.OrdenDetalleEntity;
import com.edu.upeu.pe.samanacafe.infrastructure.repository.OrdenDetalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenDetalleServiceImpl implements OrdenDetalleService {

    private final OrdenDetalleRepository ordenDetalleRepository;

    public OrdenDetalleServiceImpl(OrdenDetalleRepository ordenDetalleRepository) {
        this.ordenDetalleRepository = ordenDetalleRepository;
    }

    @Override
    public OrdenDetalleEntity create(OrdenDetalleEntity detalle) {
        return ordenDetalleRepository.save(detalle);
    }

    @Override
    public Optional<OrdenDetalleEntity> findById(Long id) {
        return ordenDetalleRepository.findById(id);
    }

    @Override
    public List<OrdenDetalleEntity> findAll() {
        return ordenDetalleRepository.findAll();
    }

    @Override
    public OrdenDetalleEntity update(Long id, OrdenDetalleEntity detalle) {
        detalle.setId(id);
        return ordenDetalleRepository.save(detalle);
    }

    @Override
    public void delete(Long id) {
        ordenDetalleRepository.deleteById(id);
    }
}


