package com.desafio.msCatalog.sku.service;


import com.desafio.msCatalog.sku.dto.SkuDTORequest;
import com.desafio.msCatalog.sku.dto.SkuDTOResponse;

public interface SkuService {
    SkuDTOResponse create(SkuDTORequest request);
    SkuDTOResponse update(SkuDTORequest request, Long id);
    void delete(Long id);
}
