package com.gymbe.powergymweb.exceptions;

/**
 * Excepción lanzada si no encuentra un correo
 */
public class EmailExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public EmailExistsException(String message) {
        super(message);
    }

}
