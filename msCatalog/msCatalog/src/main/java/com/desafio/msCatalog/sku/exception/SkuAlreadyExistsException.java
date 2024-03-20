package com.desafio.msCatalog.sku.exception;

public class SkuAlreadyExistsException extends RuntimeException{
    public SkuAlreadyExistsException(String message){
        super(message);
    }
}
