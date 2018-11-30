package ir.sargoll.shop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ir.sargoll.shop.model.Product;

public interface ProductServiceApi extends GenericService<Product> {
    Page<Product> getProductsCategory(Long id, Pageable pageable);
}
