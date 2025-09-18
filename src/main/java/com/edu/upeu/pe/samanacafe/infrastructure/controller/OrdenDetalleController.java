package com.edu.upeu.pe.samanacafe.infrastructure.controller;

import com.edu.upeu.pe.samanacafe.domain.service.OrdenDetalleService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.OrdenDetalleEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/orden-detalles")
public class OrdenDetalleController {

    private final OrdenDetalleService ordenDetalleService;

    public OrdenDetalleController(OrdenDetalleService ordenDetalleService) {
        this.ordenDetalleService = ordenDetalleService;
    }

    @PostMapping
    public ResponseEntity<OrdenDetalleEntity> create(@RequestBody OrdenDetalleEntity detalle) {
        OrdenDetalleEntity saved = ordenDetalleService.create(detalle);
        return ResponseEntity.created(URI.create("/api/orden-detalles/" + saved.getId())).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<OrdenDetalleEntity>> findAll() {
        return ResponseEntity.ok(ordenDetalleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenDetalleEntity> findById(@PathVariable Long id) {
        return ordenDetalleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenDetalleEntity> update(@PathVariable Long id, @RequestBody OrdenDetalleEntity detalle) {
        if (ordenDetalleService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ordenDetalleService.update(id, detalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (ordenDetalleService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ordenDetalleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


