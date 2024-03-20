package com.desafio.msCatalog.sku.service;

import com.desafio.msCatalog.sku.dto.MediaDTORequest;
import com.desafio.msCatalog.sku.dto.SkuDTOResponse;
import jakarta.transaction.Transactional;


public interface MediaService {
    SkuDTOResponse create(MediaDTORequest request);
    SkuDTOResponse update(MediaDTORequest request);
    void delete(Long id);

}
