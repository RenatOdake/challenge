package com.desafio.msCustomer.customer.exceptions;

public class CustomerNotFindException extends RuntimeException{
    public CustomerNotFindException(String message){
        super(message);
    }
}
