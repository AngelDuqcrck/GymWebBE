package com.gymbe.powergymweb.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String correo;

    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol_id;

    private String nombre;

}
