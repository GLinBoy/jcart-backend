package com.glinboy.jcart.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.jcart.service.dto.ProductShopItemDTO;

public interface ProductServiceApi extends GenericService<ProductShopItemDTO> {
	Page<ProductShopItemDTO> getProductsCategory(Long id, Pageable pageable);
}
