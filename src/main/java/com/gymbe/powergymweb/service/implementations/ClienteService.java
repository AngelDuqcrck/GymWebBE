package com.gymbe.powergymweb.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ClientCodecConfigurer.ClientDefaultCodecs;
import org.springframework.stereotype.Service;

import com.gymbe.powergymweb.Entity.Cliente;
import com.gymbe.powergymweb.repository.ClienteRepository;
import com.gymbe.powergymweb.service.interfaces.ClienteServiceInterface;
import com.gymbe.powergymweb.shared.dto.ClienteDTO;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service("clienteService")
public class ClienteService implements ClienteServiceInterface{

    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public List<ClienteDTO> listadoDeClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                        .map(this::convertToClienteDTO)
                        .collect(Collectors.toList());
    }


    /**
     * Convierte un objeto Plan en un objeto PlanDTO.
     *
     * @param planEntity El objeto Plan que se va a convertir.
     * @return El objeto PlanDTO resultante.
     */
    private ClienteDTO convertToClienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        BeanUtils.copyProperties(cliente, clienteDTO);
        return clienteDTO;
    }


    @Override
    public Cliente crearCliente(ClienteDTO clientedto) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clientedto, cliente);
        Cliente nuevoCliente = clienteRepository.save(cliente);
        return nuevoCliente;
    }
    
}
