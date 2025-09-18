package com.edu.upeu.pe.samanacafe.infrastructure.controller;

import com.edu.upeu.pe.samanacafe.domain.service.FacturaService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.FacturaEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @PostMapping
    public ResponseEntity<FacturaEntity> create(@RequestBody FacturaEntity factura) {
        FacturaEntity saved = facturaService.create(factura);
        return ResponseEntity.created(URI.create("/api/facturas/" + saved.getId())).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<FacturaEntity>> findAll() {
        return ResponseEntity.ok(facturaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaEntity> findById(@PathVariable Long id) {
        return facturaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaEntity> update(@PathVariable Long id, @RequestBody FacturaEntity factura) {
        if (facturaService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaService.update(id, factura));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (facturaService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        facturaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


