package com.edu.upeu.pe.samanacafe.infrastructure.controller;

import com.edu.upeu.pe.samanacafe.domain.service.DireccionService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.DireccionEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @PostMapping
    public ResponseEntity<DireccionEntity> create(@RequestBody DireccionEntity direccion) {
        DireccionEntity saved = direccionService.create(direccion);
        return ResponseEntity.created(URI.create("/api/direcciones/" + saved.getId())).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<DireccionEntity>> findAll() {
        return ResponseEntity.ok(direccionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionEntity> findById(@PathVariable Long id) {
        return direccionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DireccionEntity> update(@PathVariable Long id, @RequestBody DireccionEntity direccion) {
        if (direccionService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(direccionService.update(id, direccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (direccionService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        direccionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


