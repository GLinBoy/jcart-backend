package com.glinboy.jcart.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.service.CouponServiceApi;
import com.glinboy.jcart.service.dto.CouponDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/coupons")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class CouponController {

	private final CouponServiceApi couponService;

	@GetMapping
	public ResponseEntity<Page<CouponDTO>> getAllCoupons(Pageable pageable) {
		return ResponseEntity.ok(couponService.getAll(pageable));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteCoupon(@PathVariable Long id) {
		couponService.deleteSingleById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping(path = "/{id}/disable")
	public ResponseEntity<CouponDTO> disableCoupon(@PathVariable Long id) {
		return ResponseEntity.ok(couponService.disableCoupon(id));
	}

	@GetMapping(path = "/verify/{code}")
	public ResponseEntity<Void> verifyCoupon(@PathVariable String code) {
		if(couponService.verify(code).booleanValue()) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	// TODO Generate Coupon
}
