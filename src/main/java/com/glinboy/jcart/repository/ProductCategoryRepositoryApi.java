package com.glinboy.jcart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.ProductCategory;

public interface ProductCategoryRepositoryApi extends JpaRepository<ProductCategory, Long> {
    Page<ProductCategory> findAllByParentIsNull(Pageable pageable);
    Page<ProductCategory> findAllByParent_Id(Long parentId, Pageable pageable);
}
