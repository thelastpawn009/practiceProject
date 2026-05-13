package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }


}
