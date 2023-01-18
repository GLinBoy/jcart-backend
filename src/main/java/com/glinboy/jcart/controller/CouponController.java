package com.glinboy.jcart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.service.CouponServiceApi;
import com.glinboy.jcart.service.dto.CouponDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(path = "/coupons")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@SecurityRequirement(name = "Bearer Authentication")
public class CouponController extends GenericController<CouponDTO, CouponServiceApi> {

	public CouponController(CouponServiceApi service) {
		super(service);
	}

	@GetMapping(path = "/{id}/disable")
	public ResponseEntity<CouponDTO> disableCoupon(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.disableCoupon(id));
	}

	@GetMapping(path = "/verify/{code}")
	public ResponseEntity<Void> verifyCoupon(@PathVariable String code) {
		if(this.service.verify(code).booleanValue()) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	// TODO Generate Coupon
}
