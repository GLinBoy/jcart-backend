package com.glinboy.jcart.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Coupon;
import com.glinboy.jcart.model.ResourceNotFoundException;
import com.glinboy.jcart.repository.CouponRepositoryApi;
import com.glinboy.jcart.service.CouponServiceApi;
import com.glinboy.jcart.service.dto.CouponDTO;
import com.glinboy.jcart.service.mapper.CouponMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CouponServiceImpl extends AbstractServiceImpl<CouponDTO, Coupon, CouponMapper, CouponRepositoryApi> implements CouponServiceApi {


	public CouponServiceImpl(CouponRepositoryApi repository, CouponMapper mapper) {
		super(repository, mapper);
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
	public CouponDTO disableCoupon(Long id) {
		Coupon coupon = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Coupon not found with id = " + id));
		coupon.setIsActive(Boolean.FALSE);
		return this.mapper.toDto(repository.save(coupon));
	}
}
