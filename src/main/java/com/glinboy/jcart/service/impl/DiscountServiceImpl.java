package com.glinboy.jcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Discount;
import com.glinboy.jcart.repository.DiscountRepositoryApi;
import com.glinboy.jcart.service.DiscountServiceApi;
import com.glinboy.jcart.service.dto.DiscountDTO;
import com.glinboy.jcart.service.mapper.DiscountMapper;

@Service
@Transactional
public class DiscountServiceImpl
		extends AbstractServiceImpl<DiscountDTO, Discount, DiscountMapper, DiscountRepositoryApi>
		implements DiscountServiceApi {

	public DiscountServiceImpl(DiscountRepositoryApi repository, DiscountMapper mapper) {
		super(repository, mapper);
	}

	@Override
	public Boolean verify(Long id) {
		// FIXME implement Discount verifier
		return null;
	}
}
