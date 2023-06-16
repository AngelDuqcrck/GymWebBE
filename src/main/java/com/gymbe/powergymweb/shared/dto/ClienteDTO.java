package com.gymbe.powergymweb.shared.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ClienteDTO {
    private double altura;
    private Date fechaInicioMensualidad;
    private Date fechaNacimiento;
    private String genero;
    private double peso;
    private String nombre;
}
