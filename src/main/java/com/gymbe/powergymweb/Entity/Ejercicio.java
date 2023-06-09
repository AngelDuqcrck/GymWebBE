package com.gymbe.powergymweb.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ejercicio")
public class Ejercicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "musculo_objetivo_id")
    private MusculoObjetivo musculoObjetivo_id;

    @ManyToOne
    @JoinColumn(name = "parte_cuerpo_id")
    private ParteCuerpo parteCuerpo_id;

    @OneToMany(mappedBy = "ejercicio")
    @JsonIgnore
    private List<EjercicioRutina> ejerciciosRutinas;

    private String urlGif;


}
