package com.example.react.exception.handler;

import com.example.react.exceptions.ProjectExceptionResponse;
import com.example.react.model.exception.ProjectException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
@RestController
public class ProjectExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler
    public final ResponseEntity<Object> handleDuplicateProjectIdException(ProjectExceptionResponse ex, WebRequest request){
    
        ProjectException exception = new ProjectException(ex.getMessage());
        return new ResponseEntity<>(exception, BAD_REQUEST);
    }

}
