package com.edu.upeu.pe.samanacafe.infrastructure.service;

import com.edu.upeu.pe.samanacafe.domain.service.CarritoService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.CarritoEntity;
import com.edu.upeu.pe.samanacafe.infrastructure.repository.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceImpl implements CarritoService {

    private final CarritoRepository carritoRepository;

    public CarritoServiceImpl(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    @Override
    public CarritoEntity create(CarritoEntity carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public Optional<CarritoEntity> findById(Long id) {
        return carritoRepository.findById(id);
    }

    @Override
    public List<CarritoEntity> findAll() {
        return carritoRepository.findAll();
    }

    @Override
    public CarritoEntity update(Long id, CarritoEntity carrito) {
        carrito.setId(id);
        return carritoRepository.save(carrito);
    }

    @Override
    public void delete(Long id) {
        carritoRepository.deleteById(id);
    }
}


