package com.glinboy.jcart.service;

import com.glinboy.jcart.service.dto.CouponDTO;

public interface CouponServiceApi extends GenericService<CouponDTO> {
	
	Boolean verify(String coupon);

	CouponDTO disableCoupon(Long id);
}
