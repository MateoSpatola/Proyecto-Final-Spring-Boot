package com.mateospatola.api.dto.venta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResumenVentasResponseDTO {
    private LocalDate fecha;
    private Integer cantidadVentas;
    private Double montoTotal;
}
