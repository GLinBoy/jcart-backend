package ir.sargoll.shop.service;

import ir.sargoll.shop.model.ProductCategory;
import ir.sargoll.shop.repository.ProductCategoryRepositoryApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductCategoryServiceImpl
        extends AbstractServiceImpl<ProductCategory, ProductCategoryRepositoryApi>
        implements ProductCategoryServiceApi {
    @Override
    public Page<ProductCategory> getAll(Pageable pageable) {
        return repository.findAllByParentIsNull(pageable);
    }

    @Override
    public Page<ProductCategory> getChildMenu(Long parentId, Pageable pageable) {
        return repository.findAllByParent_Id(parentId, pageable);
    }
}
