package com.desafio.msCatalog.product.service;

import com.desafio.msCatalog.product.dto.ProductDTORequest;
import com.desafio.msCatalog.product.dto.ProductDTOResponse;

import java.util.List;

public interface ProductService {
    ProductDTOResponse create(ProductDTORequest request);
    List<ProductDTOResponse> findAll();
    ProductDTOResponse findById(Long id);
    ProductDTOResponse update(ProductDTORequest request, Long id);
    void delete(Long id);

}
