package com.mateospatola.api.dto.venta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleVentaRequestDTO {
    private Long productoId;
    private Integer cantidad;
}
