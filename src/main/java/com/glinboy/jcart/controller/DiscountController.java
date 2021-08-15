package com.glinboy.jcart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.service.DiscountServiceApi;
import com.glinboy.jcart.service.dto.DiscountDTO;

@RestController
@RequestMapping(path = "/discounts")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class DiscountController extends GenericController<DiscountDTO, DiscountServiceApi> {

	public DiscountController(DiscountServiceApi service) {
		super(service);
	}

	@GetMapping(path = "/{id}/verify")
	public ResponseEntity<Void> verifyDiscount(@PathVariable Long id) {
		if(this.service.verify(id).booleanValue()) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
