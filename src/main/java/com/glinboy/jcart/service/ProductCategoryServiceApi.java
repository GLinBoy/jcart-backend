package com.glinboy.jcart.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.jcart.service.dto.ProductCategoryDTO;

public interface ProductCategoryServiceApi extends GenericService<ProductCategoryDTO> {
	Page<ProductCategoryDTO> getChildMenu(Long parentId, Pageable pageable);

}
