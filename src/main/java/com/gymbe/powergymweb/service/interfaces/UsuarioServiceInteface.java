package com.gymbe.powergymweb.service.interfaces;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gymbe.powergymweb.shared.dto.UsuarioDTO;

public interface UsuarioServiceInteface extends UserDetailsService{

    public UsuarioDTO crearEntrenador(UsuarioDTO usuario);

    public boolean deleteEntrenador(String email);

    public List<UsuarioDTO> ListarUsuariosPorRol(String rol);

    public String crearUsuario(UsuarioDTO usuario);


}
