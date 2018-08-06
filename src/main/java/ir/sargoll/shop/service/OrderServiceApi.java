package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Order;
import org.springframework.data.domain.Page;

public interface OrderServiceApi extends GenericService<Order> {
    Page<Order> getUserOrders(Long userId);
}
