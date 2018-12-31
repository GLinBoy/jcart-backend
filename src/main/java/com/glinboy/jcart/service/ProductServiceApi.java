package com.glinboy.jcart.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.jcart.model.Product;

public interface ProductServiceApi extends GenericService<Product> {
    Page<Product> getProductsCategory(Long id, Pageable pageable);
}
