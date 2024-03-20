package com.desafio.msCatalog.sku.controller;

import com.desafio.msCatalog.sku.dto.SkuDTORequest;
import com.desafio.msCatalog.sku.dto.SkuDTOResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/v1/skus")
public interface SkuController {
    @PostMapping
    ResponseEntity<SkuDTOResponse> create(@RequestBody @Validated SkuDTORequest request, UriComponentsBuilder builder);
    @PutMapping("/{id}")
    ResponseEntity<SkuDTOResponse> update(@RequestBody @Validated SkuDTORequest request, @PathVariable Long id, UriComponentsBuilder builder);
    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

}
