package com.glinboy.jcart.service;

import com.glinboy.jcart.model.Coupon;
import com.glinboy.jcart.service.dto.CouponDTO;

public interface CouponServiceApi extends GenericService<CouponDTO> {
	
	Boolean verify(String coupon);

	Coupon disableCoupon(Long id);
}
