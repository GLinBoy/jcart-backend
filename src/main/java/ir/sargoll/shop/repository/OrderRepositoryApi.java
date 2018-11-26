package ir.sargoll.shop.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.Order;
import ir.sargoll.shop.model.OrderStatus;

public interface OrderRepositoryApi extends JpaRepository<Order, Long> {
    Page<Order> findAllByUserId(Long userId, Pageable pageable);
    Optional<Order> findByUserIdAndId(Long userId, Long orderId);
    Optional<Order> findByUserIdAndStatus(Long userId, OrderStatus status);
}
