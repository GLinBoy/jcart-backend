package com.glinboy.jcart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.ProductShopItem;

public interface ProductRepositoryApi extends JpaRepository<ProductShopItem, Long> {
    Page<ProductShopItem> findByCategories(Long categoryId, Pageable pageable);
}
