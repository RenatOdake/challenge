package com.desafio.msCatalog.category.dto;

import com.desafio.msCatalog.category.model.Category;

public record CategoryDTOResponse(
        Long id,
        String name,
        Boolean active,
        Category parent
) {
    public CategoryDTOResponse(Category category){
        this(category.getId(), category.getName(), category.getActive(), category.getParentCategory());
    }
}
