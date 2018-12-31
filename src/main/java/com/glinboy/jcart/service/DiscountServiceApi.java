package com.glinboy.jcart.service;

import com.glinboy.jcart.model.Discount;

public interface DiscountServiceApi extends GenericService<Discount> {
    Boolean verify(Long id);
}
