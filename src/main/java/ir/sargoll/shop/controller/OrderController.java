package ir.sargoll.shop.controller;

import ir.sargoll.shop.model.Order;
import ir.sargoll.shop.service.OrderServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    @Autowired
    private OrderServiceApi orderService;

    @GetMapping
    public Page<Order> getAllOrders(Pageable pageable) {
        return orderService.getAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getSingleById(id);
    }
}