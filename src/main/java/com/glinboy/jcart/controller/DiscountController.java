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

@RestController
@RequestMapping(path = "/discounts")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class DiscountController extends GenericController<DiscountDTO, DiscountServiceApi> {

	public DiscountController(DiscountServiceApi service) {
		super(service);
	}

	@GetMapping
	public ResponseEntity<Page<DiscountDTO>> getAllDiscount(Pageable pageable) {
		return ResponseEntity.ok(this.service.getAll(pageable));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<DiscountDTO> getDiscount(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getSingleById(id));
	}

	@PostMapping
	public ResponseEntity<DiscountDTO> saveDiscount(DiscountDTO discountDTO) {
		return ResponseEntity.ok(this.service.save(discountDTO));
	}

	@PutMapping
	public ResponseEntity<DiscountDTO> updateDiscount(DiscountDTO discountDTO) {
		return ResponseEntity.ok(this.service.update(discountDTO));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteDiscount(@PathVariable Long id) {
		this.service.deleteSingleById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping(path = "/{id}/verify")
	public ResponseEntity<Void> verifyDiscount(@PathVariable Long id) {
		if(this.service.verify(id).booleanValue()) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
