package com.desafio.msCatalog.product.dto;

import com.desafio.msCatalog.category.model.Category;
import com.desafio.msCatalog.product.model.Product;
import com.desafio.msCatalog.sku.model.Sku;

import java.util.HashSet;
import java.util.Set;

public record ProductDTOResponse(
        Long id,
        String name,
        String description,
        String brand,
        String material,
        Boolean active,
        Category category,
        Set<Sku> skus
) {

    public ProductDTOResponse(Product product){
        this(product.getId(), product.getName(), product.getDescription(),
                product.getBrand(), product.getMaterial(), product.getActive(), product.getCategory(), product.getSkus());

    }
}
