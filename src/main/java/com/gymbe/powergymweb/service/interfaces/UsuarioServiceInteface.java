package com.gymbe.powergymweb.service.interfaces;

import java.util.List;

import com.gymbe.powergymweb.shared.dto.UsuarioDTO;

public interface UsuarioServiceInteface {

    public UsuarioDTO crearEntrenador(UsuarioDTO usuario);

    public boolean deleteEntrenador(String email);

    public List<UsuarioDTO> ListarUsuariosPorRol(String rol);


}
