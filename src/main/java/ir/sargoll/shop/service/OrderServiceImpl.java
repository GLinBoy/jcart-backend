package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Order;
import ir.sargoll.shop.repository.OrderRepositoryApi;
import ir.sargoll.shop.repository.UserRepositoryApi;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl extends AbstractServiceImpl<Order, OrderRepositoryApi> implements OrderServiceApi {
    @Override
    public Page<Order> getUserOrders(Long userId) {
        return repository.findAllByUser(userId);
    }

    @Override
    public Order getOrderByUser(Long userId, Long orderId) {
        return repository.findByUserAndId(userId, orderId);
    }
}
