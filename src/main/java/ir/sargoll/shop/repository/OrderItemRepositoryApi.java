package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepositoryApi extends JpaRepository<OrderItem, Long> {
}
