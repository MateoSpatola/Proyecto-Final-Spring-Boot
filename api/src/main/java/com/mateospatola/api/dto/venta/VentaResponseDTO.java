package com.mateospatola.api.dto.venta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VentaResponseDTO {
    private Long id;
    private LocalDate fecha;
    private Double total;
    private Long clienteId;
    private List<DetalleVentaResponseDTO> detallesDTO;
}
