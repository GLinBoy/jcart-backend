package ir.sargoll.shop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ir.sargoll.shop.model.Order;
import ir.sargoll.shop.model.ProductOrderItem;
import ir.sargoll.shop.model.User;
import ir.sargoll.shop.model.UserAddress;
import ir.sargoll.shop.model.UserTransaction;
import ir.sargoll.shop.service.OrderServiceApi;
import ir.sargoll.shop.service.UserAddressServiceApi;
import ir.sargoll.shop.service.UserServiceApi;
import ir.sargoll.shop.service.UserTransactionServiceApi;

@RestController
@RequestMapping(path = "/users")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
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

    @GetMapping
    public Page<User> getUsers(Pageable pageable) {
        return userService.getAll(pageable);
    }

    //--- profile management

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(path = "/{user_id}")
    public User getUser(@PathVariable("user_id") Long id) {
        return userService.getSingleById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping(path = "/{user_id}")
    public User updateUser(@PathVariable("user_id") Long userId, @RequestBody User user) {
        return userService.update(user);
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @PostMapping
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

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

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping(path = "/logout")
    public void logout() {
        //FIXME After apply security
    }

    //--- order section

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(path = "/{user_id}/orders")
    public Page<Order> getUserOrders(@PathVariable("user_id") Long userId, Pageable pageable) {
        return orderService.getUserOrders(userId, pageable);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(path = "/{user_id}/orders/{order_id}")
    public Optional<Order> getUserOrder(@PathVariable("user_id") Long userId,
                                        @PathVariable("order_id") Long orderId) {
        return orderService.getOrderByUser(userId, orderId);
    }

    //--- address section

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(path = "/{user_id}/addresses")
    public Page<UserAddress> getUserAddresses(@PathVariable("user_id") Long userId, Pageable pageable) {
        return addressService.getUserAddresses(userId, pageable);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping(path = "/{user_id}/addresses")
    public UserAddress getUserAddress(@PathVariable("user_id") Long userId, @RequestBody UserAddress address) {
        return addressService.addAddressToUser(userId, address);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @DeleteMapping(path = "/{user_id}/addresses/{address_id}")
    public void deleteAddress(@PathVariable("user_id") Long userId,
                                      @PathVariable("address_id") Long addressId) {
        addressService.deleteAddress(userId, addressId);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(path = "/{user_id}/addresses/{address_id}")
    public UserAddress getUserAddress(@PathVariable("user_id") Long userId,
                                      @PathVariable("address_id") Long addressId) {
        return addressService.getAddressByUser(userId, addressId);
    }


    //--- cart section

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(path = "/{user_id}/cart")
    public Optional<Order> getUserCart(@PathVariable("user_id") Long userId) {
        return orderService.getCart(userId);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping(path = "/{user_id}/cart")
    public Order addOrderItem(@PathVariable("user_id") Long userId, @RequestBody ProductOrderItem product){
        return orderService.addToCart(userId, product);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @DeleteMapping(path = "/{user_id}/cart/{order_item_id}")
    public void deleteOrderItem(@PathVariable("user_id") Long userId,
                                @PathVariable("order_item_id") Long orderItemId){
        orderService.deleteFromCart(userId, orderItemId);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(path = "/{user_id}/cart/{order_item_id}/{number}")
    public ProductOrderItem orderItemNumber(@PathVariable("user_id") Long userId,
                                @PathVariable("order_item_id") Long orderItemId,
                                @PathVariable("number") Integer number){
        return orderService.updateOrderItemNumber(userId, orderItemId, number);
    }

    // User Transactions

    @PreAuthorize("hasAuthority('ROLE_USER')")
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
