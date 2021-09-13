package com.example.react.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectExceptionResponse extends RuntimeException{

    public ProjectExceptionResponse(String message) {
        super(message);
    }
    
}
