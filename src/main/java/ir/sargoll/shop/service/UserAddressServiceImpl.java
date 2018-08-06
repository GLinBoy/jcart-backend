package ir.sargoll.shop.service;

import ir.sargoll.shop.model.UserAddress;
import ir.sargoll.shop.repository.UserAddressRepositoryApi;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserAddressServiceImpl
        extends AbstractServiceImpl<UserAddress, UserAddressRepositoryApi>
        implements UserAddressServiceApi {
    @Override
    public Page<UserAddress> getUserAddresses(Long userId) {
        return repository.findbyUser(userId);
    }
}
