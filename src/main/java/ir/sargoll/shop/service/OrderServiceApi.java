package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Order;
import ir.sargoll.shop.model.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrderServiceApi extends GenericService<Order> {
    Page<Order> getUserOrders(Long userId, Pageable pageable);
    Optional<Order> getOrderByUser(Long userId, Long orderId);
    Optional<Order> getCart(Long userId);
    Order addToCart(Long userId, OrderItem product);
    void deleteFromCart(Long userId, Long orderItemId);
    OrderItem updateOrderItemNumber(Long userId, Long orderItemId, Integer number);
}
