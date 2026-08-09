package com.mateospatola.api.dto.venta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VentaRequestDTO {
    private Long clienteId;
    private List<DetalleVentaRequestDTO> detalles;
}
