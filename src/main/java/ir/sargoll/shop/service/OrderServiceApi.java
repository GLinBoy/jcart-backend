package ir.sargoll.shop.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ir.sargoll.shop.model.Order;
import ir.sargoll.shop.model.ProductOrderItem;

public interface OrderServiceApi extends GenericService<Order> {
    Page<Order> getUserOrders(Long userId, Pageable pageable);
    Optional<Order> getOrderByUser(Long userId, Long orderId);
    Optional<Order> getCart(Long userId);
    Order addToCart(Long userId, ProductOrderItem product);
    void deleteFromCart(Long userId, Long orderItemId);
    ProductOrderItem updateOrderItemNumber(Long userId, Long orderItemId, Integer number);
}
