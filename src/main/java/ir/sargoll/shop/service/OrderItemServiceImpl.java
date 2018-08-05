package ir.sargoll.shop.service;

import ir.sargoll.shop.model.OrderItem;
import ir.sargoll.shop.repository.OrderItemRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderItemServiceImpl extends AbstractServiceImpl<OrderItem, OrderItemRepositoryApi> implements OrderItemServiceApi {
}
