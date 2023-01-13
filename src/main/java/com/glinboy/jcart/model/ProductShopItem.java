package com.glinboy.jcart.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(name="PRODUCT_SHOP_ITEM")
public class ProductShopItem extends Product {
	
    @JsonManagedReference
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "product", cascade = {CascadeType.ALL})
    private List<ProductComment> comments;

}
