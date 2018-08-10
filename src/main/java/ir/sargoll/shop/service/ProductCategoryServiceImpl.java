package ir.sargoll.shop.service;

import ir.sargoll.shop.model.ProductCategory;
import ir.sargoll.shop.repository.ProductCategoryRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductCategoryServiceImpl
        extends AbstractServiceImpl<ProductCategory, ProductCategoryRepositoryApi>
        implements ProductCategoryServiceApi {
}
