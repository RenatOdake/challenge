package com.desafio.msCatalog.sku.service;

import com.desafio.msCatalog.sku.dto.MediaDTORequest;
import com.desafio.msCatalog.sku.dto.SkuDTOResponse;
import com.desafio.msCatalog.sku.exception.SkuNotFoundException;
import com.desafio.msCatalog.sku.model.Media;
import com.desafio.msCatalog.sku.repository.MediaRepository;
import com.desafio.msCatalog.sku.repository.SkuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Iterator;


@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService{
    private final MediaRepository mediaRepository;
    private final SkuRepository skuRepository;
    @Override
    public SkuDTOResponse create(MediaDTORequest request) {
        mediaRepository.save(new Media(request));
        return new SkuDTOResponse(skuRepository.findById(request.skuId()).orElseThrow(() ->
                new SkuNotFoundException("Sku with id "+ request.skuId()+" was not found")));
    }

    @Override
    public SkuDTOResponse update(MediaDTORequest request) {
        var mediaUpdate = mediaRepository.findMediaBySkuId(request.skuId())
                .map(media -> new Media(media.getId(), request.url(), request.skuId()))
                .orElseThrow( () -> new SkuNotFoundException(String.format("Sku not found with id: " + request.skuId())));
        mediaRepository.save(mediaUpdate);

        return new SkuDTOResponse(skuRepository.findById(request.skuId()).orElseThrow(() ->
                new SkuNotFoundException("Sku with id "+ request.skuId()+" was not found")));
    }

    @Override
    public void delete(Long id) {
        var media = mediaRepository.findMediaBySkuId(id).orElseThrow(
                () -> new SkuNotFoundException(String.format("Sku not found with id: " + id)));
        mediaRepository.delete(media);
    }
}
