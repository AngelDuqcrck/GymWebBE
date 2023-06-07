package com.gymbe.powergymweb.service.implementations;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymbe.powergymweb.Entity.Usuario;
import com.gymbe.powergymweb.exceptions.EmailExistsException;
import com.gymbe.powergymweb.repository.ClienteRepository;
import com.gymbe.powergymweb.repository.RolRepository;
import com.gymbe.powergymweb.repository.UsuarioRepository;
import com.gymbe.powergymweb.shared.dto.UsuarioDTO;

@Service("userService")
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    RolRepository rolRepository;

    
    public UsuarioDTO crearEntrenador(UsuarioDTO usuario){

        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setRol(rolRepository.findByDescripcion("ENTRENADOR"));
        BeanUtils.copyProperties(usuario, usuarioEntity);
        Usuario newEntrenador = usuarioRepository.save(usuarioEntity);
        UsuarioDTO usuarioARetornar = new UsuarioDTO();

        BeanUtils.copyProperties(newEntrenador, usuarioARetornar);

        return usuarioARetornar;
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
    
    public boolean deleteEntrenador(String email) {

        Usuario usuarioEntity = usuarioRepository.findByCorreo(email);
        //if (usuarioEntity == null) { throw new UsernameNotFoundException(email); }
        if (usuarioEntity.getRol().getId() != 2) { throw new IllegalArgumentException("El usuario con el e-mail " + email + " no es encargado."); }

        try {
            usuarioRepository.delete(usuarioEntity);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
