package com.glinboy.jcart.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.model.UserTransaction;
import com.glinboy.jcart.service.UserTransactionServiceApi;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/transactions")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class TransactionController {

	private final UserTransactionServiceApi transactionService;

	@GetMapping
	public Page<UserTransaction> getAll(Pageable pageable) {
		return transactionService.getAll(pageable);
	}

	@GetMapping(path = "/{id}")
	public UserTransaction get(@PathVariable Long id) {
		return transactionService.getSingleById(id);
	}

}