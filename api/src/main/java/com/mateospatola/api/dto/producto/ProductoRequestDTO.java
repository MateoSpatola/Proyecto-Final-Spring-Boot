package com.mateospatola.api.dto.producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoRequestDTO {
    private String nombre;
    private String marca;
    private Double costo;
    private Integer stock;
}
