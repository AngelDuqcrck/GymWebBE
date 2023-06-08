package com.gymbe.powergymweb.controller;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.gymbe.powergymweb.models.requests.UsuarioRequest;
import com.gymbe.powergymweb.models.responses.MensajeResponse;
import com.gymbe.powergymweb.models.responses.UsuarioResponse;
import com.gymbe.powergymweb.service.implementations.UsuarioService;
import com.gymbe.powergymweb.shared.dto.UsuarioDTO;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Endpoint Crear Entrenador
     * Crea un nuevo entrenador mediante una solicitud HTTP POST.
     *
     * @param usuarioRequest el objeto UsuarioRequest que contiene los datos del
     *                       entrenador a crear
     * @return un objeto MensajeResponse con un mensaje indicando si el entrenador
     *         fue creado exitosamente o si ocurrió un error
     */
    @PostMapping("/entrenador")
    public MensajeResponse crearEntrenador(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        BeanUtils.copyProperties(usuarioRequest, usuarioDTO);

        UsuarioDTO EntrenadorCreado = usuarioService.crearEntrenador(usuarioDTO);

        MensajeResponse response = new MensajeResponse();
        String mensaje;
        if (EntrenadorCreado != null)
            mensaje = "Entrenador creado";
        else
            mensaje = "Error algo salio mal";
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
    // @Secured("ROLE_ADMIN")
    @DeleteMapping("/eliminar")
    public MensajeResponse deleteEntrenador(@RequestParam String email) {
        boolean deleted = usuarioService.deleteEntrenador(email);
        String message = deleted ? "Entrenador eliminado con exito!!!" : "Oops algo salio mal";
        return new MensajeResponse(message);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/listar")
    public List<UsuarioResponse> ListarUsuariosporRol(@RequestParam String rol){
        List<UsuarioResponse> response = new ArrayList<>();
        List<UsuarioDTO> usuarioDtos = usuarioService.ListarUsuariosPorRol(rol);
        if(usuarioDtos== null) throw new EntityNotFoundException("No se encontraron usuarios");
        for (UsuarioDTO usuarioDto : usuarioDtos) {
            UsuarioResponse usuarioResponse = new UsuarioResponse();
            BeanUtils.copyProperties(usuarioDto, usuarioResponse);
            response.add(usuarioResponse);
        }

        return response;
    }

}
