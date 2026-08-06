package com.mateospatola.api.service;

import com.mateospatola.api.dto.cliente.ClienteRequestDTO;
import com.mateospatola.api.dto.cliente.ClienteResponseDTO;

import java.util.List;

public interface IClienteService {

    ClienteResponseDTO create(ClienteRequestDTO clienteRequestDTO);

    List<ClienteResponseDTO> getAll();

    ClienteResponseDTO getById(Long id);

    ClienteResponseDTO update(Long id, ClienteRequestDTO clienteRequestDTO);

    void delete(Long id);

}
