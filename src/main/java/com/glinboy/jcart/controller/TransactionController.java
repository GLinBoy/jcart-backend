package com.glinboy.jcart.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.service.UserTransactionServiceApi;
import com.glinboy.jcart.service.dto.UserTransactionDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/transactions")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class TransactionController {

	private final UserTransactionServiceApi transactionService;

	@GetMapping
	public ResponseEntity<Page<UserTransactionDTO>> getAll(Pageable pageable) {
		return ResponseEntity.ok(transactionService.getAll(pageable));
	}

	@GetMapping(path = "/{id}")
	public UserTransactionDTO get(@PathVariable Long id) {
		return transactionService.getSingleById(id);
	}

}