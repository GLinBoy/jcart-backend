package com.glinboy.jcart.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Order;
import com.glinboy.jcart.model.OrderStatus;
import com.glinboy.jcart.model.ProductOrderItem;
import com.glinboy.jcart.model.ResourceNotFoundException;
import com.glinboy.jcart.repository.OrderItemRepositoryApi;
import com.glinboy.jcart.repository.OrderRepositoryApi;
import com.glinboy.jcart.service.OrderServiceApi;
import com.glinboy.jcart.service.dto.OrderDTO;
import com.glinboy.jcart.service.dto.ProductOrderItemDTO;
import com.glinboy.jcart.service.mapper.OrderMapper;

@Service
@Transactional
public class OrderServiceImpl extends AbstractServiceImpl<OrderDTO, Order, OrderMapper, OrderRepositoryApi>
		implements OrderServiceApi {

	private final OrderItemRepositoryApi itemRepository;

	public OrderServiceImpl(OrderRepositoryApi repository, OrderMapper mapper, OrderItemRepositoryApi itemRepository) {
		super(repository, mapper);
		this.itemRepository = itemRepository;
	}

	@Override
	public Page<OrderDTO> getUserOrders(Long userId, Pageable pageable) {
		return repository.findAllByUserId(userId, pageable).map(mapper::toDto);
	}

	@Override
	public Optional<OrderDTO> getOrderByUser(Long userId, Long orderId) {
		return repository.findByUserIdAndId(userId, orderId).map(mapper::toDto);
	}

	@Override
	public Optional<OrderDTO> getCart(Long userId) {
		return repository.findByUserIdAndStatus(userId, OrderStatus.CART).map(mapper::toDto);
	}

	@Override
	public OrderDTO addToCart(Long userId, ProductOrderItemDTO product) {
		OrderDTO orderDTO = getCart(userId).orElseGet(() -> {
			OrderDTO o = new OrderDTO();
			o.setStatus(OrderStatus.CART);
			return o;
		});
		orderDTO.getItems().add(product);
		Order order = mapper.toEntity(orderDTO);
		return mapper.toDto(repository.save(order));
	}

	@Override
	public void deleteFromCart(Long userId, Long orderItemId) {
		Optional<Order> cart = getCart(userId);
		if (cart.isPresent()) {
			Optional<ProductOrderItem> orderItem = cart.get().getItems().stream()
					.filter(oi -> oi.getId().equals(orderItemId)).findAny();
			if (orderItem.isPresent()) {
				itemRepository.delete(orderItem.get());
			}
		}
	}

	@Override
	public ProductOrderItem updateOrderItemNumber(Long userId, Long orderItemId, Integer number) {
		Optional<Order> orderOptional = repository.findByUserIdAndStatus(userId, OrderStatus.CART);
		if (orderOptional.isPresent()) {
			Optional<ProductOrderItem> orderItemOptional = orderOptional.get().getItems().stream()
					.filter(oi -> oi.getId().equals(orderItemId)).findAny();
			if (orderItemOptional.isPresent()) {
				ProductOrderItem item = orderItemOptional.get();
				item.setNumber(number);
				return itemRepository.save(item);
			} else {
				throw new ResourceNotFoundException(
						String.format("Order with ID = %s doesn't exist!", orderItemId.toString()));
			}
		} else {
			throw new ResourceNotFoundException("User haven't any cart yet!");
		}
	}
}
