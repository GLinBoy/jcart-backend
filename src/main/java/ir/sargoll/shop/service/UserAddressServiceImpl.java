package ir.sargoll.shop.service;

import ir.sargoll.shop.model.UserAddress;
import ir.sargoll.shop.repository.UserAddressRepositoryApi;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserAddressServiceImpl
        extends AbstractServiceImpl<UserAddress, UserAddressRepositoryApi>
        implements UserAddressServiceApi {
}
