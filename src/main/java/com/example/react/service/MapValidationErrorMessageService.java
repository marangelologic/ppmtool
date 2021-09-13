package com.example.react.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MapValidationErrorMessageService {

    public ResponseEntity<?> MapValidationErrorMessageService(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMessageMap = new HashMap<>();
            result.getFieldErrors().forEach(error -> errorMessageMap.put(error.getField(), error.getDefaultMessage()));

            return new ResponseEntity<Map<String, String>>(errorMessageMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    public MapValidationErrorMessageService(){
        
    }
}