package ir.sargoll.shop.controller;

import ir.sargoll.shop.model.Coupon;
import ir.sargoll.shop.service.CouponServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/coupons")
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
