package com.glinboy.jcart.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.jcart.model.Order;
import com.glinboy.jcart.model.ProductOrderItem;
import com.glinboy.jcart.service.dto.OrderDTO;

public interface OrderServiceApi extends GenericService<OrderDTO> {
	Page<OrderDTO> getUserOrders(Long userId, Pageable pageable);

	Optional<OrderDTO> getOrderByUser(Long userId, Long orderId);

	Optional<OrderDTO> getCart(Long userId);

	Order addToCart(Long userId, ProductOrderItem product);

	void deleteFromCart(Long userId, Long orderItemId);

	ProductOrderItem updateOrderItemNumber(Long userId, Long orderItemId, Integer number);
}
