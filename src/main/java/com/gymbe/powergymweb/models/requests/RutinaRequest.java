package com.gymbe.powergymweb.models.requests;

import java.util.List;

import lombok.Data;

@Data
public class RutinaRequest {
    private String nombre; 

    private String descripcion;

    private List<Integer> ejercicioIds;
}