package com.gymbe.powergymweb.Entity;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double altura;

    private double peso; 

    @Column(nullable = false, length = 50)
    @NotEmpty
    private String genero;

    private Date fechaNacimiento;

    private Date fechaInicioMensualidad;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario user;


}
