package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Order;
import ir.sargoll.shop.model.OrderItem;
import ir.sargoll.shop.model.OrderStatus;
import ir.sargoll.shop.repository.OrderItemRepositoryApi;
import ir.sargoll.shop.repository.OrderRepositoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl extends AbstractServiceImpl<Order, OrderRepositoryApi> implements OrderServiceApi {

    @Autowired
    OrderItemRepositoryApi itemRepository;

    @Override
    public Page<Order> getUserOrders(Long userId, Pageable pageable) {
        return repository.findAllByUser(userId, pageable);
    }

    @Override
    public Optional<Order> getOrderByUser(Long userId, Long orderId) {
        return repository.findByUserAndId(userId, orderId);
    }

    @Override
    public Optional<Order> getCart(Long userId) {
        return repository.findByUserAndStatus(userId, OrderStatus.CART);
    }

    @Override
    public Order addToCart(Long userId, OrderItem product) {
        Order order = getCart(userId).orElseGet(()-> {
            Order o = new Order();
            o.setStatus(OrderStatus.CART);
            return o;
        });
        order.getItems().add(product);
        return repository.save(order);
    }

    @Override
    public void deleteFromCart(Long userId, Long orderItemId) {
        Optional<Order> cart = getCart(userId);
        if(cart.isPresent()) {
            Optional<OrderItem> orderItem = cart.get().getItems().stream()
                    .filter(oi -> oi.getId().equals(orderItemId)).findAny();
            if(orderItem.isPresent()){
                itemRepository.delete(orderItem.get());
            }
        }
    }

    @Override
    public OrderItem updateOrderItemNumber(Long userId, Long orderItemId, Integer number) {
        OrderItem item = itemRepository.getOne(orderItemId);
        item.setNumber(number);
        return itemRepository.save(item);
    }
}
