package com.glinboy.jcart.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.Discount;
import com.glinboy.jcart.repository.DiscountRepositoryApi;

@Service
@Transactional
public class DiscountServiceImpl extends AbstractServiceImpl<Discount, DiscountRepositoryApi> implements DiscountServiceApi {
    @Override
    public Boolean verify(Long id) {
        //FIXME implement Discount verifier
        return null;
    }
}
