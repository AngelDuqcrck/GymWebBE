package com.gymbe.powergymweb.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gymbe.powergymweb.models.requests.UserDetailsRequest;
import com.gymbe.powergymweb.service.implementations.JWTService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class AuthenticationFilter  extends UsernamePasswordAuthenticationFilter{
        
    private final AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;

    public AuthenticationFilter(AuthenticationManager authenticationManager, JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    /*
     * Intenta autenticar al usuario validando el email y la contraseña si las credenciales son validas pasa
     * a successfulAuthentication sino va a unsuccessfulAuthentication
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            UserDetailsRequest userModel = new ObjectMapper().readValue(request.getInputStream(),UserDetailsRequest.class);

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userModel.getEmail(), userModel.getPassword());

            return authenticationManager.authenticate(authToken);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /*
     * Si las credenciales son validas devuelve un token JWT el cual contiene email, rol del usuario y un tiempo
     * de expiración de 1 dia 
     */
    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authentication) throws IOException, ServletException {

        String username = ((User)authentication.getPrincipal()).getUsername();

        String token = jwtService.create(authentication);

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("mensaje", String.format("Hola %s, has iniciado sesion con exito!", username));
                    
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
        response.setContentType("application/json");

    }

    /*
     * Si las credenciales son invalidas retorna un mensaje de error
     */
    @Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("mensaje", "Error de autenticación: username o password incorrecto!");
		body.put("error", failed.getMessage());
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setStatus(401);
		response.setContentType("application/json");
	}
}
