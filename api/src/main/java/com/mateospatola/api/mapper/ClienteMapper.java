package com.mateospatola.api.mapper;

import com.mateospatola.api.dto.cliente.ClienteRequestDTO;
import com.mateospatola.api.dto.cliente.ClienteResponseDTO;
import com.mateospatola.api.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {

    public static Cliente toEntity(ClienteRequestDTO clienteRequestDTO) {
        Cliente entity = new Cliente();
        entity.setNombre(clienteRequestDTO.getNombre());
        entity.setApellido(clienteRequestDTO.getApellido());
        entity.setDni(clienteRequestDTO.getDni());
        return entity;
    }

    public static ClienteResponseDTO toResponseDTO(Cliente entity) {
        ClienteResponseDTO responseDTO = new ClienteResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setNombre(entity.getNombre());
        responseDTO.setApellido(entity.getApellido());
        responseDTO.setDni(entity.getDni());
        return responseDTO;
    }

    public static List<ClienteResponseDTO> toResponseDTOList(List<Cliente> entities) {
        List<ClienteResponseDTO> responseDTOList = new ArrayList<>();
        for (Cliente entity : entities) {
            responseDTOList.add(ClienteMapper.toResponseDTO(entity));
        }
        return responseDTOList;
    }

    public static void updateEntity(Cliente entity, ClienteRequestDTO clienteRequestDTO) {
        if (clienteRequestDTO.getNombre() != null) {
            entity.setNombre(clienteRequestDTO.getNombre());
        }
        if (clienteRequestDTO.getApellido() != null) {
            entity.setApellido(clienteRequestDTO.getApellido());
        }
        if (clienteRequestDTO.getDni() != null) {
            entity.setDni(clienteRequestDTO.getDni());
        }
    }

}
