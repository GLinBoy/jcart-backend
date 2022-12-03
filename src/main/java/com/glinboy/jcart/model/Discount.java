package com.glinboy.jcart.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Discount  extends BaseEntity {

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "USR_ID")
    private User user;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "PRODUCT_SHOP_ID")
    private ProductShopItem product;

    @Column
    private Double percent;

    @Column
    private Double ceiling;
}
