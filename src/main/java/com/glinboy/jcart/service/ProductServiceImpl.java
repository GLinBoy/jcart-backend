package com.glinboy.jcart.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.ProductShopItem;
import com.glinboy.jcart.repository.ProductRepositoryApi;

@Service
@Transactional
public class ProductServiceImpl extends AbstractServiceImpl<ProductShopItem, ProductRepositoryApi> implements ProductServiceApi {
    @Override
    public Page<ProductShopItem> getProductsCategory(Long categoryId, Pageable pageable) {
        return repository.findByCategories(categoryId, pageable);
    }
}