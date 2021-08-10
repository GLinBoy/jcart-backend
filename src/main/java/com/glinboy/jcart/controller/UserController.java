package com.glinboy.jcart.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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

import com.glinboy.jcart.service.OrderServiceApi;
import com.glinboy.jcart.service.UserAddressServiceApi;
import com.glinboy.jcart.service.UserServiceApi;
import com.glinboy.jcart.service.UserTransactionServiceApi;
import com.glinboy.jcart.service.dto.OrderDTO;
import com.glinboy.jcart.service.dto.ProductOrderItemDTO;
import com.glinboy.jcart.service.dto.UserAddressDTO;
import com.glinboy.jcart.service.dto.UserDTO;
import com.glinboy.jcart.service.dto.UserTransactionDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class UserController {

	private final UserServiceApi userService;

	private final OrderServiceApi orderService;

	private final UserAddressServiceApi addressService;

	private final UserTransactionServiceApi transactionService;

	// --- administration section

	@GetMapping
	public ResponseEntity<Page<UserDTO>> getUsers(Pageable pageable) {
		return ResponseEntity.ok(userService.getAll(pageable));
	}

	// --- profile management

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("user_id") Long id) {
		return ResponseEntity.ok(userService.getSingleById(id));
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@PutMapping(path = "/{user_id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable("user_id") Long userId, @RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.update(userDTO));
	}

	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	@PostMapping
	public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.register(userDTO));
	}

	@DeleteMapping(path = "/{user_id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("user_id") Long userId) {
		userService.deleteSingleById(userId);
		return ResponseEntity.ok().build();
	}

	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	@RequestMapping(path = "/recovery", params = "mail")
	public ResponseEntity<Void> recoveryByMail(@RequestParam String mail) {
		userService.recoveryByMail(mail);
		return ResponseEntity.ok().build();
	}

	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	@RequestMapping(path = "/recovery", params = "mobile")
	public ResponseEntity<Void> recoveryByMobile(@RequestParam String mobile) {
		userService.recoveryByMobile(mobile);
		return ResponseEntity.ok().build();
	}

	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	@PostMapping(path = "/login")
	public void login() {
		// FIXME After apply security
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@PostMapping(path = "/logout")
	public void logout() {
		// FIXME After apply security
	}

	// --- order section

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/orders")
	public Page<OrderDTO> getUserOrders(@PathVariable("user_id") Long userId, Pageable pageable) {
		return orderService.getUserOrders(userId, pageable);
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/orders/{order_id}")
	public Optional<OrderDTO> getUserOrder(@PathVariable("user_id") Long userId, @PathVariable("order_id") Long orderId) {
		return orderService.getOrderByUser(userId, orderId);
	}

	// --- address section

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/addresses")
	public Page<UserAddressDTO> getUserAddresses(@PathVariable("user_id") Long userId, Pageable pageable) {
		return addressService.getUserAddresses(userId, pageable);
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@PostMapping(path = "/{user_id}/addresses")
	public UserAddressDTO getUserAddress(@PathVariable("user_id") Long userId, @RequestBody UserAddressDTO addressDTO) {
		return addressService.addAddressToUser(userId, addressDTO);
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@DeleteMapping(path = "/{user_id}/addresses/{address_id}")
	public void deleteAddress(@PathVariable("user_id") Long userId, @PathVariable("address_id") Long addressId) {
		addressService.deleteAddress(userId, addressId);
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/addresses/{address_id}")
	public UserAddressDTO getUserAddress(@PathVariable("user_id") Long userId,
			@PathVariable("address_id") Long addressId) {
		return addressService.getAddressByUser(userId, addressId);
	}

	// --- cart section

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/cart")
	public Optional<OrderDTO> getUserCart(@PathVariable("user_id") Long userId) {
		return orderService.getCart(userId);
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@PutMapping(path = "/{user_id}/cart")
	public OrderDTO addOrderItem(@PathVariable("user_id") Long userId, @RequestBody ProductOrderItemDTO productDTO) {
		return orderService.addToCart(userId, productDTO);
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@DeleteMapping(path = "/{user_id}/cart/{order_item_id}")
	public void deleteOrderItem(@PathVariable("user_id") Long userId, @PathVariable("order_item_id") Long orderItemId) {
		orderService.deleteFromCart(userId, orderItemId);
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/cart/{order_item_id}/{number}")
	public ProductOrderItemDTO orderItemNumber(@PathVariable("user_id") Long userId,
			@PathVariable("order_item_id") Long orderItemId, @PathVariable("number") Integer number) {
		return orderService.updateOrderItemNumber(userId, orderItemId, number);
	}

	// User Transactions

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/transactions")
	public Page<UserTransactionDTO> getUserTransactions(@PathVariable("user_id") Long id, Pageable pageable) {
		return transactionService.findUserTransactions(id, pageable);
	}

	@GetMapping(path = "/{user_id}/transactions/{transaction_id}")
	public UserTransactionDTO getUserTransaction(@PathVariable("user_id") Long userId,
			@PathVariable("transaction_id") Long transactionId) {
		return transactionService.findByUserAndTransaction(userId, transactionId).get();
	}
}
