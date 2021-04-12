package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.ProductOrderItem;
import com.glinboy.jcart.repository.OrderItemRepositoryApi;
import com.glinboy.jcart.service.OrderItemServiceApi;

@Service
@Transactional
public class OrderItemServiceImpl extends AbstractServiceImpl<ProductOrderItem, OrderItemRepositoryApi> implements OrderItemServiceApi {

	public OrderItemServiceImpl(OrderItemRepositoryApi repository) {
		super(repository);
	}

}
