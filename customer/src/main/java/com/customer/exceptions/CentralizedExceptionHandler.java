package com.customer.exceptions;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    public String handleProductNotFound(CustomerNotFoundException e) {
        return e.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCustomerIdException.class)
    public String handleProductNotFound(InvalidCustomerIdException e) {
        return e.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCustomerNameException.class)
    public String handleProductNotFound(InvalidCustomerNameException e) {
        return e.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleContraintViolation(ConstraintViolationException e){
        return e.getMessage();
    }

}