package com.glinboy.jcart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.Product;

public interface ProductRepositoryApi extends JpaRepository<Product, Long> {
    Page<Product> findByCategories(Long categoryId, Pageable pageable);
}
