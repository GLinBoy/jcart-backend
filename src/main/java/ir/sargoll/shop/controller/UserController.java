package ir.sargoll.shop.controller;

import ir.sargoll.shop.model.*;
import ir.sargoll.shop.service.OrderServiceApi;
import ir.sargoll.shop.service.UserAddressServiceApi;
import ir.sargoll.shop.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserServiceApi userService;
    @Autowired
    private OrderServiceApi orderService;
    @Autowired
    private UserAddressServiceApi addressService;

    //--- administration section

    @GetMapping
    public Page<User> getUsers(Pageable pageable) {
        return userService.getAll(pageable);
    }

    //--- profile management

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getSingleById(id);
    }

    @PutMapping(path = "/users/{user_id}")
    public User updateUser(@PathVariable("user_id") Long userId, @RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @DeleteMapping(path = "/users/{user_id}")
    public void deleteUser(@PathVariable("user_id") Long userId) {
        userService.deleteSingleById(userId);
    }

    @RequestMapping(path = "/recovery", params = "mail")
    public void recoveryByMail(@RequestParam String mail) {
        userService.recoveryByMail(mail);
    }

    @RequestMapping(path = "/recovery", params = "mobile")
    public void recoveryByMobile(@RequestParam String mobile) {
        userService.recoveryByMobile(mobile);
    }

    @PostMapping(path = "/login")
    public void login() {
        //FIXME After apply security
    }

    @PostMapping(path = "/logout")
    public void logout() {
        //FIXME After apply security
    }

    //--- order section

    @GetMapping(path = "/{user_id}/orders")
    public Page<Order> getUserOrders(@PathVariable("user_id") Long id) {
        return orderService.getUserOrders(id);
    }

    @GetMapping(path = "/{user_id}/orders/{order_id}")
    public Order getUserOrder(@PathVariable("user_id") Long userId,
                              @PathVariable("order_id") Long orderId) {
        return orderService.getOrderByUser(userId, orderId);
    }

    @GetMapping(path = "/{user_id}/addresses")
    public Page<UserAddress> getUserAddresses(@PathVariable("user_id") Long userId) {
        return addressService.getUserAddresses(userId);
    }

    @GetMapping(path = "/{user_id}/addresses/{address_id}")
    public UserAddress getUserAddress(@PathVariable("user_id") Long userId,
                                      @PathVariable("address_id") Long addressId) {
        return addressService.getAddressByUser(userId, addressId);
    }

    //--- cart section

    @GetMapping(path = "/{user_id}/cart")
    public Order getUserCart(@PathVariable("user_id") Long id) {
        return null;
    }

    @GetMapping(path = "/{user_id}/cart")
    public Page<OrderItem> getUserCartItems(@PathVariable("user_id") Long id) {
        return null;
    }

    @PutMapping(path = "/{user_id}/cart")
    public OrderItem addOrderItem(@PathVariable("user_id") Long userId, Product product){
        return null;
    }

    @DeleteMapping(path = "/{user_id}/cart/{order_item_id}")
    public void deleteOrderItem(@PathVariable("user_id") Long userId,
                                @PathVariable("order_item_id") Long orderItemId){

    }

}
