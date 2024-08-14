package com.clientsup.sgc.controllers.handlers;

import com.clientsup.sgc.dto.errors.CustomError;
import com.clientsup.sgc.dto.errors.CustomListError;
import com.clientsup.sgc.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = new CustomError(
            Instant.now(),
            status.value(),
            e.getMessage(),
            request.getRequestURL().toString()
        );
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        CustomListError error = new CustomListError(
                Instant.now(),
                status.value(),
                "Erro de validação",
                request.getRequestURL().toString()
        );
        for(FieldError fieldError : e.getBindingResult().getFieldErrors()){
            error.addFieldMessage(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return  ResponseEntity.status(status).body(error);
    }

}
