package com.gymbe.powergymweb.shared.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private int id;

    private String correo;

    private String contrasena;

    private String nombre;
}
