package ir.sargoll.shop.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ir.sargoll.shop.model.Order;
import ir.sargoll.shop.model.OrderStatus;
import ir.sargoll.shop.model.ProductOrderItem;
import ir.sargoll.shop.model.ResourceNotFoundException;
import ir.sargoll.shop.repository.OrderItemRepositoryApi;
import ir.sargoll.shop.repository.OrderRepositoryApi;

@Service
@Transactional
public class OrderServiceImpl extends AbstractServiceImpl<Order, OrderRepositoryApi> implements OrderServiceApi {

    @Autowired
    private OrderItemRepositoryApi itemRepository;

    @Override
    public Page<Order> getUserOrders(Long userId, Pageable pageable) {
        return repository.findAllByUserId(userId, pageable);
    }

    @Override
    public Optional<Order> getOrderByUser(Long userId, Long orderId) {
        return repository.findByUserIdAndId(userId, orderId);
    }

    @Override
    public Optional<Order> getCart(Long userId) {
        return repository.findByUserIdAndStatus(userId, OrderStatus.CART);
    }

    @Override
    public Order addToCart(Long userId, ProductOrderItem product) {
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
            Optional<ProductOrderItem> orderItem = cart.get().getItems().stream()
                    .filter(oi -> oi.getId().equals(orderItemId)).findAny();
            if(orderItem.isPresent()){
                itemRepository.delete(orderItem.get());
            }
        }
    }

    @Override
    public ProductOrderItem updateOrderItemNumber(Long userId, Long orderItemId, Integer number) {
        Optional<Order> orderOptional = repository.findByUserIdAndStatus(userId, OrderStatus.CART);
        if(orderOptional.isPresent()){
            Optional<ProductOrderItem> orderItemOptional = orderOptional.get().getItems()
                    .stream().filter(oi -> oi.getId().equals(orderItemId)).findAny();
            if(orderItemOptional.isPresent()){
                ProductOrderItem item = orderItemOptional.get();
                item.setNumber(number);
                return itemRepository.save(item);
            } else {
                throw new ResourceNotFoundException(
                        String.format("Order with ID = %s doesn't exist!",
                                orderItemId.toString()));
            }
        } else {
            throw new ResourceNotFoundException("User haven't any cart yet!");
        }
    }
}
