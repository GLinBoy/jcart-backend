package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryApi extends JpaRepository<Product, Long> {
}
