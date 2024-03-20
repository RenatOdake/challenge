package com.desafio.msCustomer.customer.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomerControllerAdvice extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(CustomerNotFindException.class)
    protected ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFindException ex, WebRequest request){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), httpStatus.getReasonPhrase(), List.of(ex.getMessage()));
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);

    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    protected ResponseEntity<Object> handleCPFAlreadyExistsException(CustomerAlreadyExistsByCPFException ex, WebRequest request){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), httpStatus.getReasonPhrase(), List.of(ex.getMessage()));
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

}
