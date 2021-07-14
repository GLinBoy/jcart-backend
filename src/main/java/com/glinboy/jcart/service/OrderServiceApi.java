package com.glinboy.jcart.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.jcart.service.dto.OrderDTO;
import com.glinboy.jcart.service.dto.ProductOrderItemDTO;

public interface OrderServiceApi extends GenericService<OrderDTO> {
	Page<OrderDTO> getUserOrders(Long userId, Pageable pageable);

	Optional<OrderDTO> getOrderByUser(Long userId, Long orderId);

	Optional<OrderDTO> getCart(Long userId);

	OrderDTO addToCart(Long userId, ProductOrderItemDTO product);

	void deleteFromCart(Long userId, Long orderItemId);

	ProductOrderItemDTO updateOrderItemNumber(Long userId, Long orderItemId, Integer number);
}
