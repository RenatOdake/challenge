package com.desafio.msCatalog.category.model;

import com.desafio.msCatalog.category.dto.CategoryDTORequest;
import com.desafio.msCatalog.category.repository.CategoryRepository;
import com.desafio.msCatalog.product.model.Product;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Category parentCategory;


    public Category(CategoryDTORequest request){
        this.name = request.name();
        this.active = request.active();
    }

    public Category(String name, Boolean active, Category parent) {
        this.name = name;
        this.active = active;
        this.parentCategory = parent;
    }
}
