package com.mateospatola.api.dto.producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoResponseDTO {
    private Long id;
    private String nombre;
    private String marca;
    private Double precioFinal;
    private Integer stock;
}
