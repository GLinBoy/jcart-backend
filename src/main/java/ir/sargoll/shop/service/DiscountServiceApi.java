package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Discount;

public interface DiscountServiceApi extends GenericService<Discount> {
    Boolean verify(Long id);
}
