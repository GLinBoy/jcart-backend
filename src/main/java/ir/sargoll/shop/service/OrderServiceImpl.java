package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Order;
import ir.sargoll.shop.repository.OrderRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl extends AbstractServiceImpl<Order, OrderRepositoryApi> implements OrderServiceApi {
}
