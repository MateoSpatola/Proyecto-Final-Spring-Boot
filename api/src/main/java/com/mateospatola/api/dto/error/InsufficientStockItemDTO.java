package com.mateospatola.api.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InsufficientStockItemDTO {
    private Long productoId;
    private Integer stockDisponible;
    private Integer cantidadSolicitada;
}
