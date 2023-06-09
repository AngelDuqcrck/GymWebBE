package com.gymbe.powergymweb.shared.dto;

import lombok.Data;

@Data
public class PlanDTO {

    private Integer id;
    
    private String nombre;
    
    private String descripcion;

    private double precio;
}