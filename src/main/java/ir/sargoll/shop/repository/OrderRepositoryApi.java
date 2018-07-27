package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryApi extends JpaRepository<Order, Long> {
}
