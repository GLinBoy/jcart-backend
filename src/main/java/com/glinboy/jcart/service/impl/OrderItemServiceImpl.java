package com.glinboy.jcart.service.impl;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.ProductOrderItem;
import com.glinboy.jcart.repository.OrderItemRepositoryApi;
import com.glinboy.jcart.service.OrderItemServiceApi;
import com.glinboy.jcart.service.dto.ProductOrderItemDTO;
import com.glinboy.jcart.service.mapper.ProductOrderItemMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderItemServiceImpl extends
		AbstractServiceImpl<ProductOrderItemDTO, ProductOrderItem, ProductOrderItemMapper, OrderItemRepositoryApi>
		implements OrderItemServiceApi {

	public OrderItemServiceImpl(OrderItemRepositoryApi repository, ProductOrderItemMapper mapper) {
		super(repository, mapper);
	}

}
