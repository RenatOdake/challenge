package com.desafio.msCatalog.sku.repository;

import com.desafio.msCatalog.sku.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface MediaRepository extends JpaRepository<Media, Long> {

    Optional<Media> findMediaBySkuId(Long skuId);



}
