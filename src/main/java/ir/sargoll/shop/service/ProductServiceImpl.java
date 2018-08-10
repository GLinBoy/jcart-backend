package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Product;
import ir.sargoll.shop.repository.ProductRepositoryApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl extends AbstractServiceImpl<Product, ProductRepositoryApi> implements ProductServiceApi {
    @Override
    public Page<Product> getProductsCategory(Long categoryId, Pageable pageable) {
        return repository.findByCategories(categoryId);
    }
}
