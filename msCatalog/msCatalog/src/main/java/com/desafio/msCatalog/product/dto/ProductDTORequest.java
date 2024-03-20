package com.desafio.msCatalog.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record ProductDTORequest(
        @NotNull(message = "Name can't be null")
        @NotBlank(message = "Name can't be blank")
        String name,
        @NotNull(message = "Description can't be null")
        @NotBlank(message = "Description can't be blank")
        String description,
        @NotNull(message = "Brand can't be null")
        @NotBlank(message = "Brand can't be blank")
        String brand,
        @NotNull(message = "Material can't be null")
        String material,
        @NotNull(message = "Active can't be null")
        Boolean active,
        @NotNull(message = "categoryId can't be null")
        Long categoryId

        ) {

}
