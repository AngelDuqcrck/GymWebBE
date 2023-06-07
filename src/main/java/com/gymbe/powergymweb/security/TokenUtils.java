package com.gymbe.powergymweb.security;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gymbe.powergymweb.Entity.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class TokenUtils {
    
    private final static String ACCESS_TOKEN_SECRET = "gymMamaburra";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS  = 2_592_000L;


    /**
     * Método para crear el token 
     * @param nombre
     * @param email
     * @return
     */
    public static String createToken(UserDetailsImpl s) {
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime );
        Map <String, Object> extra = new HashMap<>();
        extra.put("nombre", s.getNombre());
        extra.put("id", s.getId());
        extra.put("role", s.getRol());

        return Jwts.builder()
                    .setSubject(s.getUsername())
                    .setExpiration(expirationDate)
                    .addClaims(extra)
                    .signWith(SignatureAlgorithm.HS256, ACCESS_TOKEN_SECRET.getBytes())
                    .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
        try {
            Claims claims = (Claims) Jwts.parser().setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                            .parse(token)
                            .getBody();

             String email = claims.getSubject();
        
            return new UsernamePasswordAuthenticationToken(email,null, Collections.emptyList());
        } catch(JwtException e){
            return null;
        }
    }
}
