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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/orders")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderServiceApi orderService;

	@GetMapping
	public ResponseEntity<Page<OrderDTO>> getAllOrders(Pageable pageable) {
		return ResponseEntity.ok(orderService.getAll(pageable));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
		return ResponseEntity.ok(orderService.getSingleById(id));
	}
}
