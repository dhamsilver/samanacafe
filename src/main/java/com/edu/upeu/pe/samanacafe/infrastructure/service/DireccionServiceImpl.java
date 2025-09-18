package com.edu.upeu.pe.samanacafe.infrastructure.service;

import com.edu.upeu.pe.samanacafe.domain.service.DireccionService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.DireccionEntity;
import com.edu.upeu.pe.samanacafe.infrastructure.repository.DireccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionServiceImpl(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    @Override
    public DireccionEntity create(DireccionEntity direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public Optional<DireccionEntity> findById(Long id) {
        return direccionRepository.findById(id);
    }

    @Override
    public List<DireccionEntity> findAll() {
        return direccionRepository.findAll();
    }

    @Override
    public DireccionEntity update(Long id, DireccionEntity direccion) {
        direccion.setId(id);
        return direccionRepository.save(direccion);
    }

    @Override
    public void delete(Long id) {
        direccionRepository.deleteById(id);
    }
}


