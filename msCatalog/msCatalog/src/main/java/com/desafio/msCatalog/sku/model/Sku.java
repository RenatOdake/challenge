package com.desafio.msCatalog.sku.model;

import com.desafio.msCatalog.product.model.Product;
import com.desafio.msCatalog.sku.dto.SkuDTORequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Set;

@Entity
@Table(name = "sku")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Sku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private int quantity;
    private String color;
    private String size;
    private Double height;
    private Double width;
    private Long productId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "skuId",referencedColumnName = "id")
    private Set<Media> medias = new HashSet<>();


    public Sku(SkuDTORequest request) {
        this.price = request.price();
        this.quantity = request.quantity();
        this.color = request.color();
        this.size = request.size();
        this.height = request.height();
        this.width = request.width();
        this.productId = request.productId();
    }
}
