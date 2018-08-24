package ir.sargoll.shop.service;

import ir.sargoll.shop.model.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductCategoryServiceApi extends GenericService<ProductCategory> {
    Page<ProductCategory> getChildMenu(Long parentId, Pageable pageable);

}
