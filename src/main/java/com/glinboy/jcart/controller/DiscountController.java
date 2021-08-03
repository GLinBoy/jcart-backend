package com.glinboy.jcart.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.service.DiscountServiceApi;
import com.glinboy.jcart.service.dto.DiscountDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/discounts")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class DiscountController {

	private final DiscountServiceApi discountService;

	@GetMapping
	public ResponseEntity<Page<DiscountDTO>> getAllDiscount(Pageable pageable) {
		return ResponseEntity.ok(discountService.getAll(pageable));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<DiscountDTO> getDiscount(@PathVariable Long id) {
		return ResponseEntity.ok(discountService.getSingleById(id));
	}

	@PostMapping
	public ResponseEntity<DiscountDTO> saveDiscount(DiscountDTO discountDTO) {
		return ResponseEntity.ok(discountService.save(discountDTO));
	}

	@PutMapping
	public ResponseEntity<DiscountDTO> updateDiscount(DiscountDTO discountDTO) {
		return ResponseEntity.ok(discountService.update(discountDTO));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteDiscount(@PathVariable Long id) {
		discountService.deleteSingleById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping(path = "/{id}/verify")
	public ResponseEntity<Void> verifyDiscount(@PathVariable Long id) {
		if(discountService.verify(id).booleanValue()) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
