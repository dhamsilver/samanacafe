package com.edu.upeu.pe.samanacafe.infrastructure.service;

import com.edu.upeu.pe.samanacafe.domain.service.ProductoService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.ProductoEntity;
import com.edu.upeu.pe.samanacafe.infrastructure.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoEntity create(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<ProductoEntity> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<ProductoEntity> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public ProductoEntity update(Long id, ProductoEntity producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }

    @Override
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}


