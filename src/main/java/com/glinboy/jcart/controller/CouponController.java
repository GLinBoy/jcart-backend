package com.glinboy.jcart.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<CouponDTO> getAllCoupons(Pageable pageable) {
		return couponService.getAll(pageable);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteCoupon(@PathVariable Long id) {
		couponService.deleteSingleById(id);
	}

	@GetMapping(path = "/{id}/disable")
	public CouponDTO disableCoupon(@PathVariable Long id) {
		return couponService.disableCoupon(id);
	}

	@GetMapping(path = "/verify/{code}")
	public Boolean verifyCoupon(@PathVariable String code) {
		return couponService.verify(code);
	}

	// TODO Generate Coupon
}
