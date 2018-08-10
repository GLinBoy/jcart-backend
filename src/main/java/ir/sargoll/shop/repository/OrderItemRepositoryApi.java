package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepositoryApi extends JpaRepository<OrderItem, Long> {
}
