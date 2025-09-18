package com.edu.upeu.pe.samanacafe.infrastructure.service;

import com.edu.upeu.pe.samanacafe.domain.service.PagoService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.PagoEntity;
import com.edu.upeu.pe.samanacafe.infrastructure.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;

    public PagoServiceImpl(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public PagoEntity create(PagoEntity pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public Optional<PagoEntity> findById(Long id) {
        return pagoRepository.findById(id);
    }

    @Override
    public List<PagoEntity> findAll() {
        return pagoRepository.findAll();
    }

    @Override
    public PagoEntity update(Long id, PagoEntity pago) {
        pago.setId(id);
        return pagoRepository.save(pago);
    }

    @Override
    public void delete(Long id) {
        pagoRepository.deleteById(id);
    }
}


