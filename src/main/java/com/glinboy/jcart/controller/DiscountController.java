package com.glinboy.jcart.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<DiscountDTO> getAllDiscount(Pageable pageable) {
		return discountService.getAll(pageable);
	}

	@GetMapping(path = "/{id}")
	public DiscountDTO getDiscount(@PathVariable Long id) {
		return discountService.getSingleById(id);
	}

	@PostMapping
	public DiscountDTO saveDiscount(DiscountDTO discountDTO) {
		return discountService.save(discountDTO);
	}

	@PutMapping
	public DiscountDTO updateDiscount(DiscountDTO discountDTO) {
		return discountService.update(discountDTO);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteDiscount(@PathVariable Long id) {
		discountService.deleteSingleById(id);
	}

	@GetMapping(path = "/{id}/verify")
	public Boolean verifyDiscount(@PathVariable Long id) {
		return discountService.verify(id);
	}
}
