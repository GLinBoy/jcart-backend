package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.ProductCategory;
import com.glinboy.jcart.repository.ProductCategoryRepositoryApi;
import com.glinboy.jcart.service.ProductCategoryServiceApi;
import com.glinboy.jcart.service.dto.ProductCategoryDTO;
import com.glinboy.jcart.service.mapper.ProductCategoryMapper;

@Service
@Transactional
public class ProductCategoryServiceImpl extends
		AbstractServiceImpl<ProductCategoryDTO, ProductCategory, ProductCategoryMapper, ProductCategoryRepositoryApi>
		implements ProductCategoryServiceApi {

	public ProductCategoryServiceImpl(ProductCategoryRepositoryApi repository, ProductCategoryMapper mapper) {
		super(repository, mapper);
	}

	@Override
	public Page<ProductCategory> getAll(Pageable pageable) {
		return repository.findAllByParentIsNull(pageable);
	}

	@Override
	public Page<ProductCategory> getChildMenu(Long parentId, Pageable pageable) {
		return repository.findAllByParent_Id(parentId, pageable);
	}
}
