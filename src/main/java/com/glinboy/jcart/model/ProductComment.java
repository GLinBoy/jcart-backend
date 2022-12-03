package com.glinboy.jcart.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=true)
public class ProductComment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "USER_ID", updatable = false)
    private User user;

    @Column
    private String comment;

    @Column
    private Integer rate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "PRODUCT_SHOP_ID")
    private ProductShopItem product;
}
