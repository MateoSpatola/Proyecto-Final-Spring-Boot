package com.mateospatola.api.controller;

import com.mateospatola.api.dto.producto.ProductoRequestDTO;
import com.mateospatola.api.dto.producto.ProductoResponseDTO;
import com.mateospatola.api.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;


    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> getAll() {
        return ResponseEntity.ok(productoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> create(@RequestBody ProductoRequestDTO productoRequestDTO) {
        ProductoResponseDTO created = productoService.create(productoRequestDTO);
        URI location = URI.create("/api/productos/" + created.getId());
        return ResponseEntity.created(location).body(created);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> update(@PathVariable Long id, @RequestBody ProductoRequestDTO productoRequestDTO) {
        ProductoResponseDTO updated = productoService.update(id, productoRequestDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/falta_stock")
    public ResponseEntity<List<ProductoResponseDTO>> getLowStock() {
        return ResponseEntity.ok(productoService.getLowStock());
    }

}
