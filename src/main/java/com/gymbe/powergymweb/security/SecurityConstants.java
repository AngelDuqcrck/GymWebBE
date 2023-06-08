package com.gymbe.powergymweb.security;

public class SecurityConstants {
    public static final long EXPIRATION_DATE = 86400000;// 1 dia en milisegundos
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SECRET_KEY = "gymmamaburra";

    public static String getTokenSecret() {
        return SECRET_KEY;
    }
}
