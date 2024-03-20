package com.desafio.msCatalog.category.exception;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String message){
        super(message);
    }
}
