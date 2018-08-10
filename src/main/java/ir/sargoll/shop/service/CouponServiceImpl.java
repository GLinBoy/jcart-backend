package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Coupon;
import ir.sargoll.shop.repository.CouponRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CouponServiceImpl extends AbstractServiceImpl<Coupon, CouponRepositoryApi> implements CouponServiceApi {
    @Override
    public Boolean verify(String code) {
        //FIXME Search coupon depend by user
        //FIXME Not used
        //FIXME Date used between start & end
        Optional<Coupon> couponOptional = repository.findByCode(code);
        return couponOptional.isPresent();
    }
}
