package com.desafio.msCatalog.product.service;

import com.desafio.msCatalog.category.exception.CategoryNotFoundException;
import com.desafio.msCatalog.category.model.Category;
import com.desafio.msCatalog.category.repository.CategoryRepository;
import com.desafio.msCatalog.product.dto.ProductDTORequest;
import com.desafio.msCatalog.product.dto.ProductDTOResponse;
import com.desafio.msCatalog.product.exception.ProductAlreadyExistsException;
import com.desafio.msCatalog.product.exception.ProductNotFoundException;
import com.desafio.msCatalog.product.model.Product;
import com.desafio.msCatalog.product.repository.ProductRepository;
import com.desafio.msCatalog.sku.model.Sku;
import com.desafio.msCatalog.sku.repository.SkuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public ProductDTOResponse create(ProductDTORequest request) {
        if(productRepository.existsByName(request.name())){
            throw new ProductAlreadyExistsException(String.format("Product with name: %s already exists.", request.name()));
        }
        Category category = categoryRepository.findById(request.categoryId()).orElseThrow(
                () -> new CategoryNotFoundException(String.format("Category with id "+ request.categoryId()+" was not found for this product")
                ));
        log.info("SERVICE PRODUCT - CREATING PRODUCT");
        return new ProductDTOResponse(productRepository.save(new Product(request, category)));
    }

    @Override
    public List<ProductDTOResponse> findAll() {
        return productRepository.findAll().stream().map(ProductDTOResponse::new).toList();
    }

    @Override
    public ProductDTOResponse findById(Long id) {
        return productRepository.findById(id).map(product ->
                new ProductDTOResponse(product.getId(), product.getName(),
                        product.getDescription(), product.getBrand(),
                        product.getMaterial(), product.getActive(),
                        product.getCategory(), product.getSkus())).orElseThrow(() ->
                new ProductNotFoundException(String.format("Product doesn't exist with id: %s", id)
        ));
    }

    @Override
    public ProductDTOResponse update(ProductDTORequest request, Long id) {
        Category category = categoryRepository.findById(request.categoryId()).orElseThrow(
                () -> new CategoryNotFoundException(String.format("Category with id "+ request.categoryId()+" was not found for this product")
                ));
        Product updated = productRepository.findById(id).map(product -> new Product(product.getId(), request.name(),
                request.description(), request.brand(), request.material(), request.active(),
                category, product.getSkus())).orElseThrow(()->
                new ProductNotFoundException(String.format("Product with id %s was not found", id)));
        return new ProductDTOResponse(productRepository.save(updated));
    }

    @Override
    public void delete(Long id) {
        productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException(String.format("Product with id %s was not found", id)));
        productRepository.deleteById(id);
    }
}
