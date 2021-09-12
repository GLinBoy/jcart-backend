package com.glinboy.jcart.controller;

import java.util.Optional;

import org.springdoc.core.converters.models.PageableAsQueryParam;
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

import io.swagger.v3.oas.annotations.Parameter;
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
	@PageableAsQueryParam
	public ResponseEntity<Page<UserDTO>> getUsers(@Parameter(hidden = true) Pageable pageable) {
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
	public ResponseEntity<Void> login() {
		// FIXME After apply security
		return ResponseEntity.ok().build();
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@PostMapping(path = "/logout")
	public ResponseEntity<Void> logout() {
		// FIXME After apply security
		return ResponseEntity.ok().build();
	}

	// --- order section

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/orders")
	@PageableAsQueryParam
	public ResponseEntity<Page<OrderDTO>> getUserOrders(@PathVariable("user_id") Long userId,
			@Parameter(hidden = true) Pageable pageable) {
		return ResponseEntity.ok(orderService.getUserOrders(userId, pageable));
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/orders/{order_id}")
	public ResponseEntity<OrderDTO> getUserOrder(@PathVariable("user_id") Long userId, @PathVariable("order_id") Long orderId) {
		Optional<OrderDTO> orderByUser = orderService.getOrderByUser(userId, orderId);
		if(orderByUser.isPresent()) {
			return ResponseEntity.ok(orderByUser.get());
		}
		return ResponseEntity.notFound().build();
	}

	// --- address section

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/addresses")
	@PageableAsQueryParam
	public ResponseEntity<Page<UserAddressDTO>> getUserAddresses(@PathVariable("user_id") Long userId,
			@Parameter(hidden = true) Pageable pageable) {
		return ResponseEntity.ok(addressService.getUserAddresses(userId, pageable));
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@PostMapping(path = "/{user_id}/addresses")
	public ResponseEntity<UserAddressDTO> getUserAddress(@PathVariable("user_id") Long userId, @RequestBody UserAddressDTO addressDTO) {
		return ResponseEntity.ok(addressService.addAddressToUser(userId, addressDTO));
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@DeleteMapping(path = "/{user_id}/addresses/{address_id}")
	public ResponseEntity<Void> deleteAddress(@PathVariable("user_id") Long userId, @PathVariable("address_id") Long addressId) {
		addressService.deleteAddress(userId, addressId);
		return ResponseEntity.ok().build();
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/addresses/{address_id}")
	public ResponseEntity<UserAddressDTO> getUserAddress(@PathVariable("user_id") Long userId,
			@PathVariable("address_id") Long addressId) {
		return ResponseEntity.ok(addressService.getAddressByUser(userId, addressId));
	}

	// --- cart section

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/cart")
	public ResponseEntity<OrderDTO> getUserCart(@PathVariable("user_id") Long userId) {
		Optional<OrderDTO> cart = orderService.getCart(userId);
		if(cart.isPresent()) {
			return ResponseEntity.ok(cart.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@PutMapping(path = "/{user_id}/cart")
	public ResponseEntity<OrderDTO> addOrderItem(@PathVariable("user_id") Long userId, @RequestBody ProductOrderItemDTO productDTO) {
		return ResponseEntity.ok(orderService.addToCart(userId, productDTO));
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@DeleteMapping(path = "/{user_id}/cart/{order_item_id}")
	public ResponseEntity<Void> deleteOrderItem(@PathVariable("user_id") Long userId, @PathVariable("order_item_id") Long orderItemId) {
		orderService.deleteFromCart(userId, orderItemId);
		return ResponseEntity.ok().build();
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/cart/{order_item_id}/{number}")
	public ResponseEntity<ProductOrderItemDTO> orderItemNumber(@PathVariable("user_id") Long userId,
			@PathVariable("order_item_id") Long orderItemId, @PathVariable("number") Integer number) {
		return ResponseEntity.ok(orderService.updateOrderItemNumber(userId, orderItemId, number));
	}

	// User Transactions

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping(path = "/{user_id}/transactions")
	@PageableAsQueryParam
	public ResponseEntity<Page<UserTransactionDTO>> getUserTransactions(@PathVariable("user_id") Long id,
			@Parameter(hidden = true) Pageable pageable) {
		return ResponseEntity.ok(transactionService.findUserTransactions(id, pageable));
	}

	@GetMapping(path = "/{user_id}/transactions/{transaction_id}")
	public ResponseEntity<UserTransactionDTO> getUserTransaction(@PathVariable("user_id") Long userId,
			@PathVariable("transaction_id") Long transactionId) {
		Optional<UserTransactionDTO> foundTransaction = transactionService.findByUserAndTransaction(userId, transactionId);
		if(foundTransaction.isPresent()) {
			return ResponseEntity.ok(foundTransaction.get());
		}
		return ResponseEntity.notFound().build();
	}
}
