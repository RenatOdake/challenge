package com.desafio.msCatalog.sku.exception;

public class SkuNotFoundException extends RuntimeException{
    public SkuNotFoundException(String message){
        super(message);
    }
}
