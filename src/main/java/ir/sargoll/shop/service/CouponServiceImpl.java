package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Coupon;
import ir.sargoll.shop.repository.CouponRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CouponServiceImpl extends AbstractServiceImpl<Coupon, CouponRepositoryApi> implements CouponServiceApi {
}
