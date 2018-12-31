package com.glinboy.jcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.ProductAttribute;

public interface ProductAttributeRepositoryApi extends JpaRepository<ProductAttribute, Long> {
}
