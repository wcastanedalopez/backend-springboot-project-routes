package com.bezkoder.springjwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * En resumen, esta clase EmailAlreadyExistsException se utiliza para generar una excepción cuando se
 * encuentra que un correo electrónico ya existe, y al capturarse, generará una respuesta de error con
 * el estado de respuesta HTTP 409 Conflict y el mensaje proporcionado.
 */
public class EmailAlreadyExistsException extends ResponseStatusException {

    public EmailAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}