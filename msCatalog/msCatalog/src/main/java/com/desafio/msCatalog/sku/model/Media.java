package com.desafio.msCatalog.sku.model;

import com.desafio.msCatalog.sku.dto.MediaDTORequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "media")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<String> image_url;
    private Long skuId;

    public Media(MediaDTORequest request) {
        this.image_url = request.url();
        this.skuId = request.skuId();
    }
}
