package com.glinboy.jcart.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.ProductOrderItem;
import com.glinboy.jcart.repository.OrderItemRepositoryApi;

@Service
@Transactional
public class OrderItemServiceImpl extends AbstractServiceImpl<ProductOrderItem, OrderItemRepositoryApi> implements OrderItemServiceApi {
}
