package com.gymbe.powergymweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymbe.powergymweb.Entity.Ejercicio;
import com.gymbe.powergymweb.models.requests.EjercicioRequest;
import com.gymbe.powergymweb.models.responses.MensajeResponse;
import com.gymbe.powergymweb.repository.EjercicioRepository;
import com.gymbe.powergymweb.service.implementations.EjercicioService;
import com.gymbe.powergymweb.shared.dto.EjercicioDTO;

@RestController
@RequestMapping("/ejercicio")
public class EjercicioController {
    @Autowired
    EjercicioService ejercicioService;

    /**
     * Endpoint para listar todos los ejercicios.
     *
     * @return ResponseEntity con la lista de ejercicios en el cuerpo de la
     *         respuesta.
     */
    @GetMapping
    // @Secured("ROLE_ADMIN")
    public ResponseEntity<List<EjercicioDTO>> listarEjercicios() {
        return new ResponseEntity<>(ejercicioService.listarEjercicios(), HttpStatus.OK);
    }

    /**
     * Endpoint para crear un nuevo ejercicio.
     *
     * @param ejercicioRequest El objeto EjercicioRequest que contiene los datos del
     *                         ejercicio a crear.
     * @return ResponseEntity con el mensaje de éxito en el cuerpo de la respuesta.
     */
    @PostMapping
    // @Secured("ROLE_ADMIN")
    public ResponseEntity<MensajeResponse> crearEjercicio(@RequestBody @Valid EjercicioRequest ejercicioRequest) {
        EjercicioDTO ejercicioDTO = new EjercicioDTO();
        BeanUtils.copyProperties(ejercicioRequest, ejercicioDTO);
        ejercicioService.crearEjercicio(ejercicioDTO);
        MensajeResponse mensajeResponse = new MensajeResponse("Ejercicio creado exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(mensajeResponse);
    }

}
