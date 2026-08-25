package com.mateospatola.api.mapper;

import com.mateospatola.api.dto.venta.DetalleVentaResponseDTO;
import com.mateospatola.api.dto.venta.VentaResponseDTO;
import com.mateospatola.api.model.DetalleVenta;
import com.mateospatola.api.model.Venta;

import java.util.ArrayList;
import java.util.List;

public class VentaMapper {

    public static VentaResponseDTO toResponseDTO(Venta entity) {
        VentaResponseDTO ventaResponseDTO = new VentaResponseDTO();
        ventaResponseDTO.setId(entity.getId());
        ventaResponseDTO.setFecha(entity.getFecha());
        ventaResponseDTO.setTotal(entity.getTotal());
        ventaResponseDTO.setClienteId(entity.getCliente().getId());
        ventaResponseDTO.setDetallesDTO(toDetalleVentaResponseDTOList(entity.getDetalles()));
        return ventaResponseDTO;
    }

    public static List<VentaResponseDTO> toResponseDTOList(List<Venta> entities) {
        List<VentaResponseDTO> responseDTOList = new ArrayList<>();
        for (Venta entity : entities) {
            responseDTOList.add(VentaMapper.toResponseDTO(entity));
        }
        return responseDTOList;
    }

    public static List<DetalleVentaResponseDTO> toDetalleVentaResponseDTOList(List<DetalleVenta> detalles) {
        List<DetalleVentaResponseDTO> detallesDTO = new ArrayList<>();
        for (DetalleVenta detalle : detalles) {
            DetalleVentaResponseDTO detalleDTO = new DetalleVentaResponseDTO();
            detalleDTO.setId(detalle.getId());
            detalleDTO.setVentaId(detalle.getVenta().getId());
            detalleDTO.setProductoId(detalle.getProducto().getId());
            detalleDTO.setCantidad(detalle.getCantidad());
            detalleDTO.setPrecioUnitario(detalle.getPrecioUnitario());
            detalleDTO.setSubtotal(detalle.calcularSubtotal());
            detallesDTO.add(detalleDTO);
        }
        return detallesDTO;
    }

}
