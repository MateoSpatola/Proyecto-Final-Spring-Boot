package com.mateospatola.api.dto.venta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleVentaResponseDTO {
    private Long id;
    private Long ventaId;
    private Long productoId;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
}
