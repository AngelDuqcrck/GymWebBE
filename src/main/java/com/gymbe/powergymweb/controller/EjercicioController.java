package com.gymbe.powergymweb.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/ejercicios")
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
    public List<Ejercicio> listarEjercicios() {
        return ejercicioService.listarEjercicios();
    }

    /**
     * Endpoint para listar todos los ejercicios.
     *
     * @return ResponseEntity con la lista de ejercicios en el cuerpo de la
     *         respuesta.
     */
    @GetMapping("/{id}")
    // @Secured("ROLE_ADMIN")
    public ResponseEntity<Ejercicio> buscarEjerciciosId(@PathVariable int id) {
    Optional<Ejercicio> optionalEjercicio = ejercicioService.buscarEjerciciosId(id);
    Ejercicio ejercicio = optionalEjercicio.orElseThrow(() -> new NoSuchElementException("Ejercicio no encontrado"));
    return new ResponseEntity<>(ejercicio, HttpStatus.OK);
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

    /**
     * Actualiza un ejercicio específico.
     *
     * @param ejercicioRequest Objeto EjercicioRequest que contiene los datos del
     *                         ejercicio a actualizar.
     * @param id               Identificador del ejercicio a actualizar.
     * @return ResponseEntity con un objeto MensajeResponse que indica el éxito de
     *         la operación.
     */
    @PutMapping("/{id}")
    public ResponseEntity<MensajeResponse> actualizarEjercicio(@RequestBody @Valid EjercicioRequest ejercicioRequest,
            @PathVariable Integer id) {
        EjercicioDTO ejercicioDTO = new EjercicioDTO();
        BeanUtils.copyProperties(ejercicioRequest, ejercicioDTO);
        ejercicioService.actualizarEjercicio(ejercicioDTO, id);
        MensajeResponse mensajeResponse = new MensajeResponse("Ejercicio Actualizado exitosamente");

        return ResponseEntity.ok().body(mensajeResponse);
    }

    @DeleteMapping("/{id}")
    public MensajeResponse eliminarEjercicio(@PathVariable int id){
        this.ejercicioService.elimiarEjercicio(id);
        return new MensajeResponse("Ejercicio eliminado exitosamente");
    }

}
