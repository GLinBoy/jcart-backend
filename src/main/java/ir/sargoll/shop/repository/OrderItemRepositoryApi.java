package ir.sargoll.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.ProductOrderItem;

public interface OrderItemRepositoryApi extends JpaRepository<ProductOrderItem, Long> {
}
