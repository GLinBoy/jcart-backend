package ir.sargoll.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.OrderItem;

public interface OrderItemRepositoryApi extends JpaRepository<OrderItem, Long> {
}
