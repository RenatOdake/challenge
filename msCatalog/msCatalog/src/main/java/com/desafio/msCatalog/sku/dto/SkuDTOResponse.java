package com.desafio.msCatalog.sku.dto;

import com.desafio.msCatalog.product.model.Product;
import com.desafio.msCatalog.sku.model.Media;
import com.desafio.msCatalog.sku.model.Sku;

import java.util.HashSet;
import java.util.Set;

public record SkuDTOResponse(
        Long id,
        Double price,
        int quantity,
        String color,
        String size,
        Double height,
        Double width,
        Long productId,
        Set<Media> medias
) {
    public SkuDTOResponse(Sku sku){
        this(sku.getId(), sku.getPrice(), sku.getQuantity(),
                sku.getColor(), sku.getSize(), sku.getHeight(),
                sku.getWidth(), sku.getProductId(), sku.getMedias());
    }
}
