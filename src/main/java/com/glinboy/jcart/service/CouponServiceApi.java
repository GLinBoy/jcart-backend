package com.glinboy.jcart.service;

import com.glinboy.jcart.model.Coupon;

public interface CouponServiceApi extends GenericService<Coupon> {
    Boolean verify(String coupon);

    Coupon disableCoupon(Long id);
}
