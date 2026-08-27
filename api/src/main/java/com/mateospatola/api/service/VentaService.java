package com.mateospatola.api.service;

import com.mateospatola.api.dto.venta.*;
import com.mateospatola.api.exception.NotFoundException;
import com.mateospatola.api.mapper.VentaMapper;
import com.mateospatola.api.model.Cliente;
import com.mateospatola.api.model.DetalleVenta;
import com.mateospatola.api.model.Producto;
import com.mateospatola.api.model.Venta;
import com.mateospatola.api.repository.ClienteRepository;
import com.mateospatola.api.repository.ProductoRepository;
import com.mateospatola.api.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public VentaResponseDTO create(VentaRequestDTO ventaRequestDTO) {
        Venta venta = new Venta();
        Cliente cliente = clienteRepository.findById(ventaRequestDTO.getClienteId()).orElseThrow(
                () -> new NotFoundException("Cliente con ID " + ventaRequestDTO.getClienteId() + " no encontrado.")
        );
        List<DetalleVenta> detalles = crearDetalles(venta, ventaRequestDTO.getDetalles());

        venta.setFecha(LocalDate.now());
        venta.setCliente(cliente);
        venta.setDetalles(detalles);
        venta.setTotal(venta.calcularTotal());

        Venta created = ventaRepository.save(venta);
        return VentaMapper.toResponseDTO(created);
    }


    @Override
    public List<VentaResponseDTO> getAll() {
        List<Venta> entities = ventaRepository.findAll();
        return VentaMapper.toResponseDTOList(entities);
    }

    @Override
    public VentaResponseDTO getById(Long id) {
        Venta entity = ventaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Venta con ID " + id + " no encontrada.")
        );
        return VentaMapper.toResponseDTO(entity);
    }

    @Override
    public VentaResponseDTO update(Long id, VentaRequestDTO ventaRequestDTO) {
        Venta venta = ventaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Venta con ID " + id + " no encontrada.")
        );

        if (ventaRequestDTO.getClienteId() != null) {
            Cliente cliente = clienteRepository.findById(ventaRequestDTO.getClienteId()).orElseThrow(
                    () -> new NotFoundException("Venta con ID " + id + " no encontrada.")
            );
            venta.setCliente(cliente);
        }

        if (ventaRequestDTO.getDetalles() != null) {
            List<DetalleVenta> nuevosDetalles = crearDetalles(venta, ventaRequestDTO.getDetalles());
            venta.getDetalles().clear();
            venta.getDetalles().addAll(nuevosDetalles);
        }

        venta.setFecha(LocalDate.now());
        venta.setTotal(venta.calcularTotal());

        Venta updated = ventaRepository.save(venta);
        return VentaMapper.toResponseDTO(updated);
    }

    @Override
    public void delete(Long id) {
        Venta entity = ventaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Venta con ID " + id + " no encontrada.")
        );
        ventaRepository.delete(entity);
    }

    @Override
    public List<DetalleVentaResponseDTO> getDetallesVenta(Long id) {
        Venta entity = ventaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Venta con ID " + id + " no encontrada.")
        );
        return VentaMapper.toDetalleVentaResponseDTOList(entity.getDetalles());
    }

    @Override
    public ResumenVentasResponseDTO getResumenVentas(LocalDate fecha) {
        List<Venta> entities = ventaRepository.findByFecha(fecha);
        ResumenVentasResponseDTO resumen = new ResumenVentasResponseDTO();
        resumen.setFecha(fecha);
        resumen.setCantidadVentas(entities.size());
        Double montoTotal = 0.0;
        for (Venta v : entities) {
            montoTotal += v.getTotal();
        }
        resumen.setMontoTotal(montoTotal);
        return resumen;
    }

    @Override
    public MayorVentaResponseDTO getMayorVenta() {
        Venta entity = ventaRepository.findFirstByOrderByTotalDesc().orElseThrow(
                () -> new NotFoundException("No existen ventas registradas.")
        );
        MayorVentaResponseDTO mayorVenta = new MayorVentaResponseDTO();
        mayorVenta.setId(entity.getId());
        mayorVenta.setTotal(entity.getTotal());
        int cantidadProductos = 0;
        for (DetalleVenta d : entity.getDetalles()) {
            cantidadProductos += d.getCantidad();
        }
        mayorVenta.setCantidadProductos(cantidadProductos);
        mayorVenta.setNombreCliente(entity.getCliente().getNombre());
        mayorVenta.setApellidoCliente(entity.getCliente().getApellido());
        return mayorVenta;
    }


    private List<DetalleVenta> crearDetalles(Venta venta, List<DetalleVentaRequestDTO> detallesRequestDTO) {
        List<DetalleVenta> detalles = new ArrayList<>();
        for (DetalleVentaRequestDTO detalleCreateDTO : detallesRequestDTO) {
            DetalleVenta detalle = new DetalleVenta();
            Producto producto = productoRepository.findById(detalleCreateDTO.getProductoId()).orElseThrow(
                    () -> new NotFoundException("Producto con ID " + detalleCreateDTO.getProductoId() + " no encontrado.")
            );
            detalle.setVenta(venta);
            detalle.setProducto(producto);
            detalle.setCantidad(detalleCreateDTO.getCantidad());
            detalle.setPrecioUnitario(producto.calcularPrecioFinal());
            detalles.add(detalle);
        }
        return detalles;
    }

}
