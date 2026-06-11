package com.datasoft.prueba_tecnica.utils.exceptions;

import org.springframework.http.HttpStatus;

public class BookNotFoundException extends ApiException {

    public BookNotFoundException(Long id) {
        super("No existe el libro con id: " + id, HttpStatus.NOT_FOUND);
    }
}
