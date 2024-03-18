package com.desafio.msCatalog.product.exception;

public class ProductAlreadyExists extends RuntimeException{
    public ProductAlreadyExists(String message){
        super(message);
    }
}
