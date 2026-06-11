package com.datasoft.prueba_tecnica.utils.exceptions;

import org.springframework.http.HttpStatus;

public class GenereNotFoundException extends ApiException {

    public GenereNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
