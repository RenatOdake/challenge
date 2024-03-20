package com.desafio.msCatalog.sku.dto;

import java.util.ArrayList;
import java.util.List;

public record MediaDTORequest(
        List<String> url,
        Long skuId
) {
}
