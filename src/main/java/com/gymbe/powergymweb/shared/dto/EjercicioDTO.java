package com.gymbe.powergymweb.shared.dto;

import com.gymbe.powergymweb.Entity.MusculoObjetivo;
import com.gymbe.powergymweb.Entity.ParteCuerpo;

import lombok.Data;

@Data
public class EjercicioDTO {
    
    private String descripcion;

    
    private MusculoObjetivo musculoObjetivo_id;

   
    private ParteCuerpo parteCuerpo_id;


    private String urlGif;
}
