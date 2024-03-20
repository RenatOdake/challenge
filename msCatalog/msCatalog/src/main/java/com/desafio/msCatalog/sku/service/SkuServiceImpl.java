package com.desafio.msCatalog.sku.service;

import com.desafio.msCatalog.product.exception.ProductNotFoundException;
import com.desafio.msCatalog.product.model.Product;
import com.desafio.msCatalog.product.repository.ProductRepository;
import com.desafio.msCatalog.sku.dto.SkuDTORequest;
import com.desafio.msCatalog.sku.dto.SkuDTOResponse;
import com.desafio.msCatalog.sku.exception.SkuNotFoundException;
import com.desafio.msCatalog.sku.model.Sku;
import com.desafio.msCatalog.sku.repository.SkuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class SkuServiceImpl implements SkuService{
    private final SkuRepository skuRepository;
    @Override
    public SkuDTOResponse create(SkuDTORequest request) {
        return new SkuDTOResponse(skuRepository.save(new Sku(request)));
    }

    @Override
    public SkuDTOResponse update(SkuDTORequest request, Long id) {
        var updated = skuRepository.findById(id).map(sku -> new Sku(sku.getId(), request.price(),
                request.quantity(), request.color(), request.size(),
                        request.height(), request.width(), request.productId(), sku.getMedias()))
                .orElseThrow(()-> new SkuNotFoundException(String.format("Sku was not found with id %s. ", id)));
        return new SkuDTOResponse(skuRepository.save(updated));
    }

    @Override
    public void delete(Long id) {
        skuRepository.findById(id).orElseThrow(() -> new SkuNotFoundException(String.format("Sku was not found with id: %s. ", id)));
        skuRepository.deleteById(id);
    }
}
