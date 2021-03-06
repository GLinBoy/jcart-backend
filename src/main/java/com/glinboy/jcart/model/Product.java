package com.glinboy.jcart.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
