package com.desafio.msCatalog.sku.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SkuDTORequest(

        @NotNull(message = "Price can't be null")
        Double price,
        @NotNull(message = "Quantity can't be null")
        int quantity,
        @NotNull(message = "Color can't be null")
        String color,
        @NotNull(message = "Size can't be null")
        String size,
        @NotNull(message = "Height can't be null")
        Double height,
        @NotNull(message = "Width can't be null")
        Double width,
        @NotNull(message = "ProductId can't be null")
        Long productId,
        @NotNull(message = "Images can't be null")
        List<String> images
) {
}
