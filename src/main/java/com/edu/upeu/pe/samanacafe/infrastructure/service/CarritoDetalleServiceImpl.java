package com.edu.upeu.pe.samanacafe.infrastructure.service;

import com.edu.upeu.pe.samanacafe.domain.service.CarritoDetalleService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.CarritoDetalleEntity;
import com.edu.upeu.pe.samanacafe.infrastructure.repository.CarritoDetalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoDetalleServiceImpl implements CarritoDetalleService {

    private final CarritoDetalleRepository carritoDetalleRepository;

    public CarritoDetalleServiceImpl(CarritoDetalleRepository carritoDetalleRepository) {
        this.carritoDetalleRepository = carritoDetalleRepository;
    }

    @Override
    public CarritoDetalleEntity create(CarritoDetalleEntity detalle) {
        return carritoDetalleRepository.save(detalle);
    }

    @Override
    public Optional<CarritoDetalleEntity> findById(Long id) {
        return carritoDetalleRepository.findById(id);
    }

    @Override
    public List<CarritoDetalleEntity> findAll() {
        return carritoDetalleRepository.findAll();
    }

    @Override
    public CarritoDetalleEntity update(Long id, CarritoDetalleEntity detalle) {
        detalle.setId(id);
        return carritoDetalleRepository.save(detalle);
    }

    @Override
    public void delete(Long id) {
        carritoDetalleRepository.deleteById(id);
    }
}


