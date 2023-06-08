package com.gymbe.powergymweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymbe.powergymweb.models.responses.MensajeResponse;
import com.gymbe.powergymweb.service.implementations.ClienteService;
import com.gymbe.powergymweb.shared.dto.ClienteDTO;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        return new ResponseEntity<>(clienteService.listadoDeClientes(), HttpStatus.OK);
    }

    @PostMapping
    public MensajeResponse crearCliente(@RequestBody @Valid ClienteDTO clienteDTO){
        clienteService.crearCliente(clienteDTO); 
        return new MensajeResponse("Cliente creado con éxito");
    }

}
