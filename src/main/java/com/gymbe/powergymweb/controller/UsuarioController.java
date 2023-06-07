package com.gymbe.powergymweb.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gymbe.powergymweb.models.requests.UsuarioRequest;
import com.gymbe.powergymweb.models.responses.MensajeResponse;
import com.gymbe.powergymweb.service.implementations.UsuarioService;
import com.gymbe.powergymweb.shared.dto.UsuarioDTO;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/entrenador")
    public MensajeResponse crearEntrenador(@RequestBody @Valid UsuarioRequest usuarioRequest){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        BeanUtils.copyProperties(usuarioRequest, usuarioDTO);

        UsuarioDTO EntrenadorCreado = usuarioService.crearEntrenador(usuarioDTO);

        MensajeResponse response = new MensajeResponse();
        String mensaje;
        if(EntrenadorCreado!= null) mensaje ="Entrenador creado";
        else mensaje ="Error algo salio mal";
        response.setMessage(mensaje);
        return response;

    }



    /**
     * Endpoint para eliminación por email de usuarios con el rol de entrenador
     * Solo está permitido para el rol de administrador.
     *
     * @param email el correo electrónico del usuario.
     * @return mensaje informativo
    */
    //@Secured("ROLE_ADMIN")
    @DeleteMapping("/eliminar/{email}")
    public MensajeResponse deleteEntrenador(@PathVariable String email) {
        boolean deleted = usuarioService.deleteEntrenador(email);
        String message = deleted ? "Entrenador eliminado con exito!!!":"Oops algo salio mal";
        return new MensajeResponse(message);
    }
}
