package com.glinboy.jcart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class ProductShopItem extends Product {
	
    @JsonManagedReference
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "product", cascade = {CascadeType.ALL})
    private List<ProductComment> comments;

}
