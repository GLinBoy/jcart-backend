package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeRepositoryApi extends JpaRepository<ProductAttribute, Long> {
}
