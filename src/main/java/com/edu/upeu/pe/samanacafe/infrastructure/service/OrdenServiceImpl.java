package com.edu.upeu.pe.samanacafe.infrastructure.service;

import com.edu.upeu.pe.samanacafe.domain.service.OrdenService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.OrdenEntity;
import com.edu.upeu.pe.samanacafe.infrastructure.repository.OrdenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenServiceImpl implements OrdenService {

    private final OrdenRepository ordenRepository;

    public OrdenServiceImpl(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    @Override
    public OrdenEntity create(OrdenEntity orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public Optional<OrdenEntity> findById(Long id) {
        return ordenRepository.findById(id);
    }

    @Override
    public List<OrdenEntity> findAll() {
        return ordenRepository.findAll();
    }

    @Override
    public OrdenEntity update(Long id, OrdenEntity orden) {
        orden.setId(id);
        return ordenRepository.save(orden);
    }

    @Override
    public void delete(Long id) {
        ordenRepository.deleteById(id);
    }
}


