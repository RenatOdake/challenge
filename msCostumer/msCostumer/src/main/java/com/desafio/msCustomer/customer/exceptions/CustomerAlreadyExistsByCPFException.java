package com.desafio.msCustomer.customer.exceptions;

public class CustomerAlreadyExistsByCPFException extends RuntimeException{
    public CustomerAlreadyExistsByCPFException(String message){
        super(message);
    }
}
