package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.ProductShopItem;
import com.glinboy.jcart.repository.ProductRepositoryApi;
import com.glinboy.jcart.service.ProductServiceApi;

@Service
@Transactional
public class ProductServiceImpl extends AbstractServiceImpl<ProductShopItem, ProductRepositoryApi>
		implements ProductServiceApi {
	
	public ProductServiceImpl(ProductRepositoryApi repository) {
		super(repository);
	}

	@Override
	public Page<ProductShopItem> getProductsCategory(Long categoryId, Pageable pageable) {
		return repository.findByCategories(categoryId, pageable);
	}
}
