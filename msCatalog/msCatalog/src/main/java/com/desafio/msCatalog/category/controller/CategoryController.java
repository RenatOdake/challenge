package com.desafio.msCatalog.category.controller;

import com.desafio.msCatalog.category.dto.CategoryDTORequest;
import com.desafio.msCatalog.category.dto.CategoryDTOResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("/v1/categories")
public interface CategoryController {
    @PostMapping
    ResponseEntity<CategoryDTOResponse> create(@RequestBody @Validated CategoryDTORequest request, UriComponentsBuilder builder);

    @GetMapping
    ResponseEntity<List<CategoryDTOResponse>> findAll();

    @GetMapping("/{id}/products")
    ResponseEntity<CategoryDTOResponse> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<CategoryDTOResponse> update(@RequestBody @Validated CategoryDTORequest request, UriComponentsBuilder builder, @PathVariable Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id, UriComponentsBuilder builder);




}
