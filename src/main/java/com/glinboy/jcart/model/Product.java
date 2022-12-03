package com.glinboy.jcart.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Data
@EqualsAndHashCode(callSuper=true)
public abstract class Product extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany
    @JoinTable(name = "JOIN_PRODUCTS_ATTRIBUTES",
            joinColumns = @JoinColumn(name = "PRODUCT_SHOP_ID"),
            inverseJoinColumns = @JoinColumn(name = "ATTRIBUTE_ID")
    )
    private List<ProductAttribute> attributes;

    @Column
    private Double price;

    @Transient
    private Double rate;

    @Column
    private String code;

    @ManyToMany
    @JoinTable(name = "JOIN_PRODUCTS_CATEGORIES",
        joinColumns = @JoinColumn(name = "PRODUCT_ID"),
        inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")
    )
    private List<ProductCategory> categories;

    @OneToMany
    private List<Image> images;

    @JsonBackReference
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "product")
    private Set<Discount> discounts;
}
