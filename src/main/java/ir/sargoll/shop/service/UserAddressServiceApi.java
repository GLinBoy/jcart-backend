package ir.sargoll.shop.service;

import ir.sargoll.shop.model.UserAddress;
import org.springframework.data.domain.Page;

public interface UserAddressServiceApi extends GenericService<UserAddress> {
    Page<UserAddress> getUserAddresses(Long userId);
    UserAddress getAddressByUser(Long userId, Long addressId);
}
