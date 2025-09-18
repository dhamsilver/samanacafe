package com.edu.upeu.pe.samanacafe.infrastructure.controller;

import com.edu.upeu.pe.samanacafe.domain.service.CarritoService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.CarritoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/carritos")
public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @PostMapping
    public ResponseEntity<CarritoEntity> create(@RequestBody CarritoEntity carrito) {
        CarritoEntity saved = carritoService.create(carrito);
        return ResponseEntity.created(URI.create("/api/carritos/" + saved.getId())).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<CarritoEntity>> findAll() {
        return ResponseEntity.ok(carritoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarritoEntity> findById(@PathVariable Long id) {
        return carritoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarritoEntity> update(@PathVariable Long id, @RequestBody CarritoEntity carrito) {
        if (carritoService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carritoService.update(id, carrito));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (carritoService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        carritoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


