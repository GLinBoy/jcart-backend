package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.ProductShopItem;
import com.glinboy.jcart.repository.ProductRepositoryApi;
import com.glinboy.jcart.service.ProductServiceApi;
import com.glinboy.jcart.service.dto.ProductShopItemDTO;
import com.glinboy.jcart.service.mapper.ProductShopItemMapper;

@Service
@Transactional
public class ProductServiceImpl
		extends AbstractServiceImpl<ProductShopItemDTO, ProductShopItem, ProductShopItemMapper, ProductRepositoryApi>
		implements ProductServiceApi {

	public ProductServiceImpl(ProductRepositoryApi repository, ProductShopItemMapper mapper) {
		super(repository, mapper);
	}

	@Override
	public Page<ProductShopItemDTO> getProductsCategory(Long categoryId, Pageable pageable) {
		return repository.findByCategories(categoryId, pageable).map(mapper::toDto);
	}
}
