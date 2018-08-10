package ir.sargoll.shop.controller;

import ir.sargoll.shop.service.CouponServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/coupon")
public class CouponController {
    @Autowired
    private CouponServiceApi couponService;

    @GetMapping(path = "/verify/{code}")
    public Boolean verifyCoupon(@PathVariable String code) {
        return couponService.verify(code);
    }

    //TODO Generate Coupon
}
