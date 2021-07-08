package com.glinboy.jcart.service.mapper;

import org.mapstruct.Mapper;

import com.glinboy.jcart.model.Coupon;
import com.glinboy.jcart.service.dto.CouponDTO;

@Mapper(componentModel = "spring", uses = {})
public interface CouponMapper extends EntityMapper<CouponDTO, Coupon>{

}
