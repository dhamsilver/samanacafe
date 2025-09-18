package com.edu.upeu.pe.samanacafe.infrastructure.controller;

import com.edu.upeu.pe.samanacafe.domain.service.CarritoDetalleService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.CarritoDetalleEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/carrito-detalles")
public class CarritoDetalleController {

    private final CarritoDetalleService carritoDetalleService;

    public CarritoDetalleController(CarritoDetalleService carritoDetalleService) {
        this.carritoDetalleService = carritoDetalleService;
    }

    @PostMapping
    public ResponseEntity<CarritoDetalleEntity> create(@RequestBody CarritoDetalleEntity detalle) {
        CarritoDetalleEntity saved = carritoDetalleService.create(detalle);
        return ResponseEntity.created(URI.create("/api/carrito-detalles/" + saved.getId())).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<CarritoDetalleEntity>> findAll() {
        return ResponseEntity.ok(carritoDetalleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarritoDetalleEntity> findById(@PathVariable Long id) {
        return carritoDetalleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarritoDetalleEntity> update(@PathVariable Long id, @RequestBody CarritoDetalleEntity detalle) {
        if (carritoDetalleService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carritoDetalleService.update(id, detalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (carritoDetalleService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        carritoDetalleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


