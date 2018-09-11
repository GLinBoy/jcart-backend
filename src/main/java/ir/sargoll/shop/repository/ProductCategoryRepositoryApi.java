package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepositoryApi extends JpaRepository<ProductCategory, Long> {
    Page<ProductCategory> findAllByParentIsNull(Pageable pageable);
    Page<ProductCategory> findAllByParent_Id(Long parentId, Pageable pageable);
}
