package com.mateospatola.api.controller;

import com.mateospatola.api.dto.venta.*;
import com.mateospatola.api.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;


    @GetMapping
    public ResponseEntity<List<VentaResponseDTO>> getAll() {
        return ResponseEntity.ok(ventaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<VentaResponseDTO> create(@RequestBody VentaRequestDTO ventaRequestDTO) {
        VentaResponseDTO created = ventaService.create(ventaRequestDTO);
        URI location = URI.create("/api/ventas/" + created.getId());
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaResponseDTO> update(@PathVariable Long id, @RequestBody VentaRequestDTO ventaRequestDTO) {
        VentaResponseDTO updated = ventaService.update(id, ventaRequestDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ventaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<List<DetalleVentaResponseDTO>> getDetallesVenta(@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.getDetallesVenta(id));
    }

    @GetMapping("/resumen/{fecha}")
    public ResponseEntity<ResumenVentasResponseDTO> getResumenVentas(@PathVariable LocalDate fecha) {
        return ResponseEntity.ok(ventaService.getResumenVentas(fecha));
    }

}
