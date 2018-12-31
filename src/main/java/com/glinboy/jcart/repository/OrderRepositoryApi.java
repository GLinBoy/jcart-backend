package com.glinboy.jcart.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.Order;
import com.glinboy.jcart.model.OrderStatus;

public interface OrderRepositoryApi extends JpaRepository<Order, Long> {
    Page<Order> findAllByUserId(Long userId, Pageable pageable);
    Optional<Order> findByUserIdAndId(Long userId, Long orderId);
    Optional<Order> findByUserIdAndStatus(Long userId, OrderStatus status);
}
