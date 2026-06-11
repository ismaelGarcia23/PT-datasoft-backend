package com.datasoft.prueba_tecnica.utils.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends ApiException {

    public UserAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
