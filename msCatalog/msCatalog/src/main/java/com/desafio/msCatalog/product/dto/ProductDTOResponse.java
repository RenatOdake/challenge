package com.desafio.msCatalog.product.controller;

public record ProductDTOResponse(
        Long id,
        String name,
        String description,
        String brand,
        String material,
        Boolean active,
        Long category_id
) {

    public ProductDTOResponse(Product product){

    }
}
