package com.gymbe.powergymweb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymbe.powergymweb.Entity.Usuario;
import com.gymbe.powergymweb.repository.UsuarioRepository;

@RestController
@RequestMapping("/users")
public class UsuariosController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping 
    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }
}
