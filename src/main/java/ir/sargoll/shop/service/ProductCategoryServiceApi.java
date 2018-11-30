package ir.sargoll.shop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ir.sargoll.shop.model.ProductCategory;

public interface ProductCategoryServiceApi extends GenericService<ProductCategory> {
    Page<ProductCategory> getChildMenu(Long parentId, Pageable pageable);

}
