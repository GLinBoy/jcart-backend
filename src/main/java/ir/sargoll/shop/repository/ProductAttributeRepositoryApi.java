package ir.sargoll.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.ProductAttribute;

public interface ProductAttributeRepositoryApi extends JpaRepository<ProductAttribute, Long> {
}
