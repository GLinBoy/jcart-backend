package ir.sargoll.shop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ir.sargoll.shop.model.UserAddress;

public interface UserAddressServiceApi extends GenericService<UserAddress> {
    Page<UserAddress> getUserAddresses(Long userId, Pageable pageable);
    UserAddress getAddressByUser(Long userId, Long addressId);
    UserAddress addAddressToUser(Long userId, UserAddress address);
    void deleteAddress(Long userId, Long addressId);
}
