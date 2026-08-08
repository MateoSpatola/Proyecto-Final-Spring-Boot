package com.mateospatola.api.service;

import com.mateospatola.api.dto.producto.ProductoRequestDTO;
import com.mateospatola.api.dto.producto.ProductoResponseDTO;

import java.util.List;

public interface IProductoService {

    ProductoResponseDTO create(ProductoRequestDTO productoRequestDTO);

    List<ProductoResponseDTO> getAll();

    ProductoResponseDTO getById(Long id);

    ProductoResponseDTO update(Long id, ProductoRequestDTO productoRequestDTO);

    void delete(Long id);

}
