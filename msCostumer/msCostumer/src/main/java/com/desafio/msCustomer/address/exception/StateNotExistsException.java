package com.desafio.msCustomer.address.exception;

public class StateNotExistsException extends RuntimeException {
    public StateNotExistsException(String message){
        super(message);
    }
}
