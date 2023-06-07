package com.gymbe.powergymweb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gymbe.powergymweb.Entity.Usuario;
import com.gymbe.powergymweb.repository.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario s = usuarioRepository.findOneByCorreo(username)
                        .orElseThrow(() -> new UsernameNotFoundException("El usuario no se éxite"));
        
        return new UserDetailsImpl(s);
    }
    
}
