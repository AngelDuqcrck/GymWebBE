package com.gymbe.powergymweb.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gymbe.powergymweb.Entity.Usuario;
import com.gymbe.powergymweb.repository.RolRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{

    private final Usuario usuario;  

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
       return usuario.getContrasena();
    }

    @Override
    public String getUsername() {
       return this.usuario.getCorreo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre(){
        return this.usuario.getNombre();
    }

    public int getId(){
        return this.usuario.getId();
    }

    
    public String getRol(){
        return this.usuario.getRol_id().getDescripcion();
    }
}
