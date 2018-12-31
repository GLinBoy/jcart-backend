package com.glinboy.jcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.jcart.model.Coupon;
import com.glinboy.jcart.service.CouponServiceApi;

@RestController
@RequestMapping(path = "/coupons")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class CouponController {
    @Autowired
    private CouponServiceApi couponService;


    @GetMapping
    public Page<Coupon> getAllCoupons(Pageable pageable){
        return couponService.getAll(pageable);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCoupon(@PathVariable Long id){
        couponService.deleteSingleById(id);
    }

    @GetMapping(path = "/{id}/disable")
    public Coupon disableCoupon(@PathVariable Long id){
        return couponService.disableCoupon(id);
    }

    @GetMapping(path = "/verify/{code}")
    public Boolean verifyCoupon(@PathVariable String code) {
        return couponService.verify(code);
    }

    //TODO Generate Coupon
}
