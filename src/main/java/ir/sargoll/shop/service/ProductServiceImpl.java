package ir.sargoll.shop.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ir.sargoll.shop.model.Product;
import ir.sargoll.shop.repository.ProductRepositoryApi;

@Service
@Transactional
public class ProductServiceImpl extends AbstractServiceImpl<Product, ProductRepositoryApi> implements ProductServiceApi {
    @Override
    public Page<Product> getProductsCategory(Long categoryId, Pageable pageable) {
        return repository.findByCategories(categoryId, pageable);
    }
}
