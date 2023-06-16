package com.gymbe.powergymweb.models.requests;

import com.gymbe.powergymweb.Entity.MusculoObjetivo;
import com.gymbe.powergymweb.Entity.ParteCuerpo;

import lombok.Data;

@Data
public class EjercicioRequest {
    
    private String descripcion;

    
    private Integer musculoObjetivo_id;

   
    private Integer parteCuerpo_id;


    private String urlGif;

}
