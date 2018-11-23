package ir.sargoll.shop.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ir.sargoll.shop.model.ProductOrderItem;
import ir.sargoll.shop.repository.OrderItemRepositoryApi;

@Service
@Transactional
public class OrderItemServiceImpl extends AbstractServiceImpl<ProductOrderItem, OrderItemRepositoryApi> implements OrderItemServiceApi {
}
