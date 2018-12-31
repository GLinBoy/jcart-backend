package com.glinboy.jcart.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.jcart.model.ProductCategory;

public interface ProductCategoryServiceApi extends GenericService<ProductCategory> {
    Page<ProductCategory> getChildMenu(Long parentId, Pageable pageable);

}
