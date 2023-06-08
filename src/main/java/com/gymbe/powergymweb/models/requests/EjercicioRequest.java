package com.gymbe.powergymweb.models.requests;

import com.gymbe.powergymweb.Entity.MusculoObjetivo;
import com.gymbe.powergymweb.Entity.ParteCuerpo;

import lombok.Data;

@Data
public class EjercicioRequest {
    
    private String descripcion;

    
    private MusculoObjetivo musculoObjetivo_id;

   
    private ParteCuerpo parteCuerpo_id;


    private String urlGif;

}
