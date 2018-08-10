package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Coupon;

public interface CouponServiceApi extends GenericService<Coupon> {
    Boolean verify(String coupon);
}
