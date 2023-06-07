package com.gymbe.powergymweb.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plan")
public class Cliente {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double altura;

    private double peso; 

    private String genero;

    private Date fechaNacimiento;

    private Date fechaInicioMensualidad;


}
