package com.desafio.msCatalog.sku.controller;

import com.desafio.msCatalog.sku.dto.MediaDTORequest;
import com.desafio.msCatalog.sku.dto.SkuDTORequest;
import com.desafio.msCatalog.sku.dto.SkuDTOResponse;
import com.desafio.msCatalog.sku.service.MediaServiceImpl;
import com.desafio.msCatalog.sku.service.SkuServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.UriComponentsBuilder;
@Controller
@RequiredArgsConstructor
@Slf4j
public class SkuControllerImpl implements SkuController{
    private final SkuServiceImpl skuService;
    private final MediaServiceImpl mediaService;
    @Override
    public ResponseEntity<SkuDTOResponse> create(SkuDTORequest request, UriComponentsBuilder builder) {
        var sku =skuService.create(request);
        var skuResponse = mediaService.create(new MediaDTORequest(request.images(), sku.id()));
        var uri = builder.path("/v1/skus").buildAndExpand(skuResponse.id()).toUri();
        return ResponseEntity.created(uri).body(skuResponse);
    }

    @Override
    public ResponseEntity<SkuDTOResponse> update(SkuDTORequest request, Long id, UriComponentsBuilder builder) {
        var sku = skuService.update(request, id);
        log.info("INFO - SERVICE - UPDATED SKU");
        var skuResponse = mediaService.update(new MediaDTORequest(request.images(), sku.id()));
        log.info("INFO - SERVICE - UPDATED IMAGES SKU");
        var uri = builder.path("/v1/skus/{id}").buildAndExpand(skuResponse.id()).toUri();
        return ResponseEntity.ok().location(uri).body(skuResponse);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        mediaService.delete(id);
        skuService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
