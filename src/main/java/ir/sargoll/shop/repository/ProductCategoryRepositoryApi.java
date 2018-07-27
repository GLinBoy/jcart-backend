package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepositoryApi extends JpaRepository<ProductCategory, Long> {
}
