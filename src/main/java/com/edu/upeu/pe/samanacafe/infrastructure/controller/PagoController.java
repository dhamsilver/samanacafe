package com.edu.upeu.pe.samanacafe.infrastructure.controller;

import com.edu.upeu.pe.samanacafe.domain.service.PagoService;
import com.edu.upeu.pe.samanacafe.infrastructure.entity.PagoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public ResponseEntity<PagoEntity> create(@RequestBody PagoEntity pago) {
        PagoEntity saved = pagoService.create(pago);
        return ResponseEntity.created(URI.create("/api/pagos/" + saved.getId())).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<PagoEntity>> findAll() {
        return ResponseEntity.ok(pagoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoEntity> findById(@PathVariable Long id) {
        return pagoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoEntity> update(@PathVariable Long id, @RequestBody PagoEntity pago) {
        if (pagoService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pagoService.update(id, pago));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (pagoService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        pagoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


