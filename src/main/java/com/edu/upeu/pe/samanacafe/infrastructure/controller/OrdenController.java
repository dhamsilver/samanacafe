package com.edu.upeu.pe.samanacafe.infrastructure.controller;

import com.edu.upeu.pe.samanacafe.domain.service.OrdenService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.OrdenEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @PostMapping
    public ResponseEntity<OrdenEntity> create(@RequestBody OrdenEntity orden) {
        OrdenEntity saved = ordenService.create(orden);
        return ResponseEntity.created(URI.create("/api/ordenes/" + saved.getId())).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<OrdenEntity>> findAll() {
        return ResponseEntity.ok(ordenService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenEntity> findById(@PathVariable Long id) {
        return ordenService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenEntity> update(@PathVariable Long id, @RequestBody OrdenEntity orden) {
        if (ordenService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ordenService.update(id, orden));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (ordenService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ordenService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


