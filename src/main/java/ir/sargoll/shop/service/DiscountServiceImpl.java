package ir.sargoll.shop.service;

import ir.sargoll.shop.model.Discount;
import ir.sargoll.shop.repository.DiscountRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DiscountServiceImpl extends AbstractServiceImpl<Discount, DiscountRepositoryApi> implements DiscountServiceApi {
    @Override
    public Boolean verify(Long id) {
        //FIXME implement Discount verifier
        return null;
    }
}
