package com.mateospatola.api.service;

import com.mateospatola.api.dto.producto.ProductoRequestDTO;
import com.mateospatola.api.dto.producto.ProductoResponseDTO;
import com.mateospatola.api.exception.NotFoundException;
import com.mateospatola.api.mapper.ProductoMapper;
import com.mateospatola.api.repository.ProductoRepository;
import com.mateospatola.api.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public ProductoResponseDTO create(ProductoRequestDTO productoRequestDTO) {
        Producto entity = ProductoMapper.toEntity(productoRequestDTO);
        Producto created = productoRepository.save(entity);
        return ProductoMapper.toResponseDTO(created);
    }

    @Override
    public List<ProductoResponseDTO> getAll() {
        List<Producto> entities = productoRepository.findAll();
        return ProductoMapper.toResponseDTOList(entities);
    }

    @Override
    public ProductoResponseDTO getById(Long id) {
        Producto entity = productoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Producto con el id: " + id + " no encontrado.")
        );
        return ProductoMapper.toResponseDTO(entity);
    }

    @Override
    public ProductoResponseDTO update(Long id, ProductoRequestDTO productoRequestDTO) {
        Producto entity = productoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Producto con el id: " + id + " no encontrado para actualizar.")
        );
        ProductoMapper.updateEntity(entity, productoRequestDTO);
        Producto updated = productoRepository.save(entity);
        return ProductoMapper.toResponseDTO(updated);
    }

    @Override
    public void delete(Long id) {
        Producto entity = productoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Producto con el id: " + id + " no encontrado para eliminar.")
        );
        productoRepository.delete(entity);
    }

}
