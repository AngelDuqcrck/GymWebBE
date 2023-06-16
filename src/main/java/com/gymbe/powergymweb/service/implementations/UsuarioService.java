package com.gymbe.powergymweb.service.implementations;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;


import com.gymbe.powergymweb.Entity.Rol;
import com.gymbe.powergymweb.Entity.Usuario;
import com.gymbe.powergymweb.exceptions.EmailExistsException;
import com.gymbe.powergymweb.repository.ClienteRepository;
import com.gymbe.powergymweb.repository.RolRepository;
import com.gymbe.powergymweb.repository.UsuarioRepository;
import com.gymbe.powergymweb.service.interfaces.UsuarioServiceInteface;
import com.gymbe.powergymweb.shared.dto.UsuarioDTO;

@Service("userService")
public class UsuarioService implements UsuarioServiceInteface {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    RolRepository rolRepository;

    /**
     * Crea un nuevo entrenador a partir de un objeto UsuarioDTO.
     *
     * @param usuario el objeto UsuarioDTO que contiene los datos del entrenador a
     *                crear
     * @return el objeto UsuarioDTO del entrenador creado
     */
    @Override
    public UsuarioDTO crearEntrenador(UsuarioDTO usuario) {

        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setRol(rolRepository.findByDescripcion("ROLE_ENTRENADOR"));
        BeanUtils.copyProperties(usuario, usuarioEntity);
        Usuario newEntrenador = usuarioRepository.save(usuarioEntity);
        UsuarioDTO usuarioARetornar = new UsuarioDTO();

        BeanUtils.copyProperties(newEntrenador, usuarioARetornar);

        return usuarioARetornar;
    }

    /**
     * Crea un nuevo entrenador a partir de un objeto UsuarioDTO.
     *
     * @param usuario el objeto UsuarioDTO que contiene los datos del entrenador a
     *                crear
     * @return el objeto UsuarioDTO del entrenador creado
     */
    @Override
    public List<UsuarioDTO> ListarUsuariosPorRol(String rol) {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        List<Usuario> userEntities = new ArrayList<>();

        Rol rolEntity = rolRepository.findByDescripcion(rol);
        if(rolEntity== null) throw new EntityNotFoundException("Rol no encontrado");
        userEntities = usuarioRepository.findByRol(rolEntity);

        for (Usuario userEntity : userEntities) {
            UsuarioDTO usuarioDto = new UsuarioDTO();
            BeanUtils.copyProperties(userEntity, usuarioDto);
            usuarios.add(usuarioDto);
        }

        return usuarios;
    }

    /**
     * Eliminar encargado
     * 
     * @param email El correo electrónico del encargado que se va a eliminar.
     * @return true si el encargado se eliminó correctamente, false en caso
     *         contrario.
     * @throws UsernameNotFoundException si no se encuentra un usuario con el correo
     *                                   electrónico proporcionado.
     * @throws IllegalArgumentException  si el usuario con el correo electrónico
     *                                   proporcionado no es un encargado.
     */

    @Override
    public boolean deleteEntrenador(String email) {

        Usuario usuarioEntity = usuarioRepository.findByCorreo(email);
        // if (usuarioEntity == null) { throw new UsernameNotFoundException(email); }
        if (usuarioEntity.getRol().getId() != 2) {
            throw new IllegalArgumentException("El usuario con el e-mail " + email + " no es encargado.");
        }

        try {
            usuarioRepository.delete(usuarioEntity);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario userEntity = usuarioRepository.findByCorreo(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (userEntity.getRol() != null) {
            authorities.add(new SimpleGrantedAuthority(userEntity.getRol().getDescripcion()));
        } else {
            throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
        }
        return new User(userEntity.getCorreo(), userEntity.getContrasena(), authorities);
    }

}
