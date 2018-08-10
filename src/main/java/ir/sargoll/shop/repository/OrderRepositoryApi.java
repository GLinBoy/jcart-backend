package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.Order;
import ir.sargoll.shop.model.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepositoryApi extends JpaRepository<Order, Long> {
    Page<Order> findAllByUser(Long userId, Pageable pageable);
    Optional<Order> findByUserAndId(Long userId, Long orderId);
    Optional<Order> findByUserAndStatus(Long userId, OrderStatus status);
}
