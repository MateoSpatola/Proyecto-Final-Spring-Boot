package com.mateospatola.api.service;

import com.mateospatola.api.dto.cliente.ClienteRequestDTO;
import com.mateospatola.api.dto.cliente.ClienteResponseDTO;
import com.mateospatola.api.exception.NotFoundException;
import com.mateospatola.api.mapper.ClienteMapper;
import com.mateospatola.api.model.Cliente;
import com.mateospatola.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public ClienteResponseDTO create(ClienteRequestDTO clienteRequestDTO) {
        Cliente entity = ClienteMapper.toEntity(clienteRequestDTO);
        Cliente created = clienteRepository.save(entity);
        return ClienteMapper.toResponseDTO(created);
    }

    @Override
    public List<ClienteResponseDTO> getAll() {
        List<Cliente> entities = clienteRepository.findAll();
        return ClienteMapper.toResponseDTOList(entities);
    }

    @Override
    public ClienteResponseDTO getById(Long id) {
        Cliente entity = clienteRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Cliente con ID " + id + " no encontrado.")
        );
        return ClienteMapper.toResponseDTO(entity);
    }

    @Override
    public ClienteResponseDTO update(Long id, ClienteRequestDTO clienteRequestDTO) {
        Cliente entity = clienteRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Cliente con ID " + id + " no encontrado.")
        );
        ClienteMapper.updateEntity(entity, clienteRequestDTO);
        Cliente updated = clienteRepository.save(entity);
        return ClienteMapper.toResponseDTO(updated);

    }

    @Override
    public void delete(Long id) {
        Cliente entity = clienteRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Cliente con ID " + id + " no encontrado.")
        );
        clienteRepository.delete(entity);
    }
}
