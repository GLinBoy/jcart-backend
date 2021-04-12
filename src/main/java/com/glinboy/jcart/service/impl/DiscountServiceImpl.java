package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Discount;
import com.glinboy.jcart.repository.DiscountRepositoryApi;
import com.glinboy.jcart.service.DiscountServiceApi;

@Service
@Transactional
public class DiscountServiceImpl extends AbstractServiceImpl<Discount, DiscountRepositoryApi>
		implements DiscountServiceApi {
	
	public DiscountServiceImpl(DiscountRepositoryApi repository) {
		super(repository);
	}

	@Override
	public Boolean verify(Long id) {
		// FIXME implement Discount verifier
		return null;
	}
}
