package com.mateospatola.api.service;

import com.mateospatola.api.dto.venta.DetalleVentaResponseDTO;
import com.mateospatola.api.dto.venta.VentaRequestDTO;
import com.mateospatola.api.dto.venta.VentaResponseDTO;

import java.util.List;

public interface IVentaService {

    VentaResponseDTO create(VentaRequestDTO ventaRequestDTO);

    List<VentaResponseDTO> getAll();

    VentaResponseDTO getById(Long id);

    VentaResponseDTO update(Long id, VentaRequestDTO ventaRequestDTO);

    void delete(Long id);

    List<DetalleVentaResponseDTO> getDetallesVenta(Long id);

}
