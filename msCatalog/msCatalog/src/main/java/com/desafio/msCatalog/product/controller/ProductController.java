package com.desafio.msCatalog.product.controller;

import com.desafio.msCatalog.product.dto.ProductDTORequest;
import com.desafio.msCatalog.product.dto.ProductDTOResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("/v1/products")
public interface ProductController {
    @PostMapping
    ResponseEntity<ProductDTOResponse> create(@Validated @RequestBody ProductDTORequest request, UriComponentsBuilder builder);
    @GetMapping
    ResponseEntity<List<ProductDTOResponse>> findAll();
    @GetMapping("/{id}")
    ResponseEntity<ProductDTOResponse> findById(@PathVariable Long Id);
    @PutMapping("/{id}")
    ResponseEntity<ProductDTOResponse> update(@Validated @RequestBody ProductDTORequest request,UriComponentsBuilder builder, @PathVariable Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);


}
