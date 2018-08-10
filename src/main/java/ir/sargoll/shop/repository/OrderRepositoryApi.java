package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryApi extends JpaRepository<Order, Long> {
    Page<Order> findAllByUser(Long userId);
    Order findByUserAndId(Long userId, Long orderId);
}
