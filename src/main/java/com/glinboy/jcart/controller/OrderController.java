package com.glinboy.jcart.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.service.OrderServiceApi;
import com.glinboy.jcart.service.dto.OrderDTO;

@RestController
@RequestMapping(path = "/orders")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class OrderController extends GenericController<OrderDTO, OrderServiceApi> {

	public OrderController(OrderServiceApi service) {
		super(service);
	}

	@GetMapping
	public ResponseEntity<Page<OrderDTO>> getAllOrders(Pageable pageable) {
		return ResponseEntity.ok(this.service.getAll(pageable));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getSingleById(id));
	}
}
