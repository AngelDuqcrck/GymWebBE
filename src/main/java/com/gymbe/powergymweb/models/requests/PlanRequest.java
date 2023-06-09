package com.gymbe.powergymweb.models.requests;

import lombok.Data;

@Data
public class PlanRequest {
    private String nombre;
    private String descripcion;
    private Double precio;
}