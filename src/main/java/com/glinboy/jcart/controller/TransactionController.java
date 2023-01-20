package com.glinboy.jcart.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.service.UserTransactionServiceApi;
import com.glinboy.jcart.service.dto.UserTransactionDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(path = "/transactions")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@SecurityRequirement(name = "Bearer Authentication")
public class TransactionController extends GenericController<UserTransactionDTO, UserTransactionServiceApi> {

	public TransactionController(UserTransactionServiceApi service) {
		super(service);
	}

}