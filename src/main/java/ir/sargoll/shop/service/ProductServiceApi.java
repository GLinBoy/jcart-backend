package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductServiceApi extends GenericService<Product> {
    Page<Product> getProductsCategory(Long id, Pageable pageable);
}
