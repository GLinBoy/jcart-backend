package com.glinboy.jcart.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.jcart.model.ProductShopItem;

public interface ProductServiceApi extends GenericService<ProductShopItem> {
    Page<ProductShopItem> getProductsCategory(Long id, Pageable pageable);
}
