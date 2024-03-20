package com.desafio.msCatalog.product.controller;

import com.desafio.msCatalog.product.dto.ProductDTORequest;
import com.desafio.msCatalog.product.dto.ProductDTOResponse;
import com.desafio.msCatalog.product.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

    private final ProductServiceImpl service;
    @Override
    public ResponseEntity<ProductDTOResponse> create(ProductDTORequest request, UriComponentsBuilder builder) {
        ProductDTOResponse response = service.create(request);
        var uri = builder.path("/v1/products").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @Override
    public ResponseEntity<List<ProductDTOResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<ProductDTOResponse> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<ProductDTOResponse> update(ProductDTORequest request, UriComponentsBuilder builder, Long id) {
        var response = service.update(request, id);
        var uri = builder.path("/v1/products/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.ok().location(uri).body(response);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
