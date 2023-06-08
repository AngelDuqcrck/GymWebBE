package com.gymbe.powergymweb.service.interfaces;

import java.util.List;

import com.gymbe.powergymweb.Entity.Cliente;
import com.gymbe.powergymweb.shared.dto.ClienteDTO;

public interface ClienteServiceInterface {
    
    public List<ClienteDTO> listadoDeClientes();

    public Cliente crearCliente(ClienteDTO cliente);
}
