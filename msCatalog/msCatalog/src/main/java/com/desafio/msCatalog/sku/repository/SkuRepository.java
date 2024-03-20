package com.desafio.msCatalog.sku.repository;

import com.desafio.msCatalog.sku.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuRepository extends JpaRepository<Sku, Long> {
}
