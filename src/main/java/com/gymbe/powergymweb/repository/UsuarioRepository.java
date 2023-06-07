package com.gymbe.powergymweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymbe.powergymweb.Entity.Rol;
import com.gymbe.powergymweb.Entity.Usuario;

import java.util.List;
import java.util.Optional;



public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Usuario findByCorreo(String correo);

    @Override
    Optional<Usuario> findById(Integer integer);

    List<Usuario> findByRol(Rol rol);

}
