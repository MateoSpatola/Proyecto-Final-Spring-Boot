package com.mateospatola.api.mapper;

import com.mateospatola.api.dto.producto.ProductoRequestDTO;
import com.mateospatola.api.dto.producto.ProductoResponseDTO;
import com.mateospatola.api.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoMapper {

    public static Producto toEntity(ProductoRequestDTO productoRequestDTO) {
        Producto entity = new Producto();
        entity.setNombre(productoRequestDTO.getNombre());
        entity.setMarca(productoRequestDTO.getMarca());
        entity.setCosto(productoRequestDTO.getCosto());
        entity.setStock(productoRequestDTO.getStock());
        return entity;
    }

    public static ProductoResponseDTO toResponseDTO(Producto entity) {
        ProductoResponseDTO responseDTO = new ProductoResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setNombre(entity.getNombre());
        responseDTO.setMarca(entity.getMarca());
        responseDTO.setPrecioFinal(entity.calcularPrecioFinal());
        responseDTO.setStock(entity.getStock());
        return responseDTO;
    }

    public static List<ProductoResponseDTO> toResponseDTOList(List<Producto> entities) {
        List<ProductoResponseDTO> responseDTOList = new ArrayList<>();
        for (Producto entity : entities) {
            responseDTOList.add(ProductoMapper.toResponseDTO(entity));
        }
        return responseDTOList;
    }

    public static void updateEntity(Producto entity, ProductoRequestDTO productoRequestDTO) {
        if (productoRequestDTO.getNombre() != null) {
            entity.setNombre(productoRequestDTO.getNombre());
        }
        if (productoRequestDTO.getMarca() != null) {
            entity.setMarca(productoRequestDTO.getMarca());
        }
        if (productoRequestDTO.getCosto() != null) {
            entity.setCosto(productoRequestDTO.getCosto());
        }
        if (productoRequestDTO.getStock() != null) {
            entity.setStock(productoRequestDTO.getStock());
        }
    }

}
