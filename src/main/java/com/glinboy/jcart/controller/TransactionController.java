package com.glinboy.jcart.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.service.UserTransactionServiceApi;
import com.glinboy.jcart.service.dto.UserTransactionDTO;

@RestController
@RequestMapping(path = "/transactions")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class TransactionController extends GenericController<UserTransactionDTO, UserTransactionServiceApi> {

	public TransactionController(UserTransactionServiceApi service) {
		super(service);
	}

}