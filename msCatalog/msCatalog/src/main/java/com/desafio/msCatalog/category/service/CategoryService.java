package com.desafio.msCatalog.category.service;

import com.desafio.msCatalog.category.dto.CategoryDTORequest;
import com.desafio.msCatalog.category.dto.CategoryDTOResponse;

import java.util.List;

public interface CategoryService {
    CategoryDTOResponse create(CategoryDTORequest request);
    CategoryDTOResponse findById(Long id);
    CategoryDTOResponse update(CategoryDTORequest request, Long id);
    List<CategoryDTOResponse> findAll();
    void delete(Long id);
}
