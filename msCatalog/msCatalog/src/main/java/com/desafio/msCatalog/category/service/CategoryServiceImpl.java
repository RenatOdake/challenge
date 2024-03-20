package com.desafio.msCatalog.category.service;

import com.desafio.msCatalog.category.dto.CategoryDTORequest;
import com.desafio.msCatalog.category.dto.CategoryDTOResponse;
import com.desafio.msCatalog.category.exception.CategoryAlreadyExistsException;
import com.desafio.msCatalog.category.exception.CategoryNotFoundException;
import com.desafio.msCatalog.category.model.Category;
import com.desafio.msCatalog.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    @Override
    public CategoryDTOResponse create(CategoryDTORequest request) {
        if(categoryRepository.existsByName(request.name())){
            throw new CategoryAlreadyExistsException(String.format("Category with name %s already exists.", request.name()));
        }
        if(request.parentId() != null){
            Category parent = categoryRepository.findById(request.parentId()).orElseThrow(() -> new CategoryNotFoundException(String.format("Category with id %s was not found", request.parentId())));
            return new CategoryDTOResponse(categoryRepository.save(new Category(request.name(), request.active(), parent)));
        }
        return new CategoryDTOResponse(categoryRepository.save(new Category(request)));

    }

    @Override
    public CategoryDTOResponse findById(Long id) {
        return categoryRepository.findById(id).map(CategoryDTOResponse::new).orElseThrow(()->
                new CategoryNotFoundException(String.format("Category with id: %s doesn't exist", id)));
    }

    @Override
    public CategoryDTOResponse update(CategoryDTORequest request, Long id) {
        Category updated = categoryRepository.findById(id).map(category ->
                new Category(category.getId(), request.name(), request.active(), category.getParentCategory())).orElseThrow(
                        ()-> new CategoryNotFoundException(String.format("Category with id: %s doesn't exist", id)));
        if(request.parentId() != null && !request.parentId().equals(id)){
            Category parent = categoryRepository.findById(request.parentId()).orElseThrow(() -> new CategoryNotFoundException(String.format("Category with id %s was not found", request.parentId())));
            return new CategoryDTOResponse(categoryRepository.save(new Category(updated.getId(), updated.getName(), updated.getActive(), parent)));
        }
        return new CategoryDTOResponse(categoryRepository.save(updated));
    }

    @Override
    public List<CategoryDTOResponse> findAll() {
        return categoryRepository.findAll().stream().map(CategoryDTOResponse::new).toList();
    }

    @Override
    public void delete(Long id) {
        categoryRepository.findById(id).orElseThrow(()->
                new CategoryNotFoundException(String.format("Category with id: %s doesn't exist", id)));
        categoryRepository.deleteById(id);
    }
}
