package ir.sargoll.shop.controller;

import ir.sargoll.shop.model.Discount;
import ir.sargoll.shop.service.DiscountServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/discounts")
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
