package com.glinboy.jcart.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Coupon;
import com.glinboy.jcart.model.ResourceNotFoundException;
import com.glinboy.jcart.repository.CouponRepositoryApi;
import com.glinboy.jcart.service.CouponServiceApi;

@Service
@Transactional
public class CouponServiceImpl extends AbstractServiceImpl<Coupon, CouponRepositoryApi> implements CouponServiceApi {
	
	public CouponServiceImpl(CouponRepositoryApi repository) {
		super(repository);
	}

	@Override
	public Boolean verify(String code) {
		// FIXME Search coupon depend by user
		// FIXME Not used
		// FIXME Date used between start & end
		Optional<Coupon> couponOptional = repository.findByCode(code);
		return couponOptional.isPresent();
	}

	@Override
	public Coupon disableCoupon(Long id) {
		Coupon coupon = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Coupon not found with id = " + id));
		coupon.setIsActive(Boolean.FALSE);
		return repository.save(coupon);
	}
}
