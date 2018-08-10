package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryApi extends JpaRepository<Product, Long> {
    Page<Product> findByCategories(Long categoryId, Pageable pageable);
}
