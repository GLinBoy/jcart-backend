package com.glinboy.jcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.glinboy.jcart.model.Discount;
import com.glinboy.jcart.service.DiscountServiceApi;

@RestController
@RequestMapping(path = "/discounts")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class DiscountController {
    @Autowired
    private DiscountServiceApi discountService;

    @GetMapping
    public Page<Discount> getAllDiscount(Pageable pageable) {
        return discountService.getAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public Discount getDiscount(@PathVariable Long id) {
        return discountService.getSingleById(id);
    }

    @PostMapping
    public Discount saveDiscount(Discount discount) {
        return discountService.save(discount);
    }

    @PutMapping
    public Discount updateDiscount(Discount discount) {
        return discountService.update(discount);
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
