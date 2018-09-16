package ir.sargoll.shop.controller;

import ir.sargoll.shop.model.*;
import ir.sargoll.shop.service.OrderServiceApi;
import ir.sargoll.shop.service.UserAddressServiceApi;
import ir.sargoll.shop.service.UserServiceApi;
import ir.sargoll.shop.service.UserTransactionServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserServiceApi userService;
    @Autowired
    private OrderServiceApi orderService;
    @Autowired
    private UserAddressServiceApi addressService;
    @Autowired
    private UserTransactionServiceApi transactionService;

    //--- administration section

    @Secured({"ROLE_ADMIN"})
    @GetMapping
    public Page<User> getUsers(Pageable pageable) {
        return userService.getAll(pageable);
    }

    //--- profile management

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(path = "/{user_id}")
    public User getUser(@PathVariable("user_id") Long id) {
        return userService.getSingleById(id);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping(path = "/{user_id}")
    public User updateUser(@PathVariable("user_id") Long userId, @RequestBody User user) {
        return userService.update(user);
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @PostMapping
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping(path = "/{user_id}")
    public void deleteUser(@PathVariable("user_id") Long userId) {
        userService.deleteSingleById(userId);
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @RequestMapping(path = "/recovery", params = "mail")
    public void recoveryByMail(@RequestParam String mail) {
        userService.recoveryByMail(mail);
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @RequestMapping(path = "/recovery", params = "mobile")
    public void recoveryByMobile(@RequestParam String mobile) {
        userService.recoveryByMobile(mobile);
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @PostMapping(path = "/login")
    public void login() {
        //FIXME After apply security
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping(path = "/logout")
    public void logout() {
        //FIXME After apply security
    }

    //--- order section

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(path = "/{user_id}/orders")
    public Page<Order> getUserOrders(@PathVariable("user_id") Long userId, Pageable pageable) {
        return orderService.getUserOrders(userId, pageable);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(path = "/{user_id}/orders/{order_id}")
    public Optional<Order> getUserOrder(@PathVariable("user_id") Long userId,
                                        @PathVariable("order_id") Long orderId) {
        return orderService.getOrderByUser(userId, orderId);
    }

    //--- address section

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(path = "/{user_id}/addresses")
    public Page<UserAddress> getUserAddresses(@PathVariable("user_id") Long userId, Pageable pageable) {
        return addressService.getUserAddresses(userId, pageable);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping(path = "/{user_id}/addresses")
    public UserAddress getUserAddress(@PathVariable("user_id") Long userId, @RequestBody UserAddress address) {
        return addressService.addAddressToUser(userId, address);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping(path = "/{user_id}/addresses/{address_id}")
    public void deleteAddress(@PathVariable("user_id") Long userId,
                                      @PathVariable("address_id") Long addressId) {
        addressService.deleteAddress(userId, addressId);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(path = "/{user_id}/addresses/{address_id}")
    public UserAddress getUserAddress(@PathVariable("user_id") Long userId,
                                      @PathVariable("address_id") Long addressId) {
        return addressService.getAddressByUser(userId, addressId);
    }


    //--- cart section

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(path = "/{user_id}/cart")
    public Optional<Order> getUserCart(@PathVariable("user_id") Long userId) {
        return orderService.getCart(userId);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping(path = "/{user_id}/cart")
    public Order addOrderItem(@PathVariable("user_id") Long userId, @RequestBody OrderItem product){
        return orderService.addToCart(userId, product);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping(path = "/{user_id}/cart/{order_item_id}")
    public void deleteOrderItem(@PathVariable("user_id") Long userId,
                                @PathVariable("order_item_id") Long orderItemId){
        orderService.deleteFromCart(userId, orderItemId);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(path = "/{user_id}/cart/{order_item_id}/{number}")
    public OrderItem orderItemNumber(@PathVariable("user_id") Long userId,
                                @PathVariable("order_item_id") Long orderItemId,
                                @PathVariable("number") Integer number){
        return orderService.updateOrderItemNumber(userId, orderItemId, number);
    }

    // User Transactions

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(path = "/{user_id}/transactions")
    public Page<UserTransaction> getUserTransactions(@PathVariable("user_id") Long id, Pageable pageable) {
        return transactionService.findUserTransactions(id, pageable);
    }

    @GetMapping(path = "/{user_id}/transactions/{transaction_id}")
    public UserTransaction getUserTransaction(@PathVariable("user_id") Long userId,
                                              @PathVariable("transaction_id") Long transactionId) {
        return transactionService.findByUserAndTransaction(userId, transactionId).get();
    }
}
