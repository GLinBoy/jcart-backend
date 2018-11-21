package ir.sargoll.shop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ir.sargoll.shop.model.OrderItem;
import ir.sargoll.shop.repository.OrderItemRepositoryApi;

@Service
@Transactional
public class OrderItemServiceImpl extends AbstractServiceImpl<OrderItem, OrderItemRepositoryApi> implements OrderItemServiceApi {
}
