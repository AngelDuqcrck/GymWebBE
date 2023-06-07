package com.gymbe.powergymweb.models.requests;

import lombok.Data;

@Data
public class UsuarioRequest {
    
    private String correo;

    private String contrasena;

    private String nombre;
}
