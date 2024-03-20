package com.desafio.msCatalog.product.model;

import com.desafio.msCatalog.category.model.Category;
import com.desafio.msCatalog.product.dto.ProductDTORequest;
import com.desafio.msCatalog.sku.model.Sku;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String brand;
    private String material;
    private Boolean active;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name="categoryId", referencedColumnName = "id")
    private Category category;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Set<Sku> skus = new HashSet<>();
    public Product(ProductDTORequest request, Category category) {
        this.name = request.name();
        this.description = request.description();
        this.brand = request.brand();
        this.material=request.material();
        this.active = request.active();
        this.category = category;

    }
}
