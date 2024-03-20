package com.desafio.msCatalog.category.controller;

import com.desafio.msCatalog.category.dto.CategoryDTORequest;
import com.desafio.msCatalog.category.dto.CategoryDTOResponse;
import com.desafio.msCatalog.category.service.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryControllerImpl implements CategoryController{
    private final CategoryServiceImpl categoryService;
    @Override
    public ResponseEntity<CategoryDTOResponse> create(CategoryDTORequest request, UriComponentsBuilder builder) {
        var response = categoryService.create(request);
        var uri = builder.path("/v1/categories").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @Override
    public ResponseEntity<List<CategoryDTOResponse>> findAll() {
        return ResponseEntity.ok().body(categoryService.findAll());
    }

    @Override
    public ResponseEntity<CategoryDTOResponse> findById(Long id) {
        return ResponseEntity.ok().body(categoryService.findById(id));
    }

    @Override
    public ResponseEntity<CategoryDTOResponse> update(CategoryDTORequest request, UriComponentsBuilder builder, Long id) {
        var response = categoryService.update(request, id);
        var uri= builder.path("/v1/categories/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.ok().location(uri).body(response);
    }

    @Override
    public ResponseEntity<Void> delete(Long id, UriComponentsBuilder builder) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
