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

@RestController
@RequestMapping(path = "/coupons")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class CouponController extends GenericController<CouponDTO, CouponServiceApi> {

	public CouponController(CouponServiceApi service) {
		super(service);
	}

	@GetMapping
	public ResponseEntity<Page<CouponDTO>> getAllCoupons(Pageable pageable) {
		return ResponseEntity.ok(this.service.getAll(pageable));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteCoupon(@PathVariable Long id) {
		this.service.deleteSingleById(id);
		return ResponseEntity.ok().build();
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
