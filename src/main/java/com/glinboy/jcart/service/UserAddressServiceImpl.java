package com.glinboy.jcart.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.User;
import com.glinboy.jcart.model.UserAddress;
import com.glinboy.jcart.repository.UserAddressRepositoryApi;
import com.glinboy.jcart.repository.UserRepositoryApi;

@Service
@Transactional
public class UserAddressServiceImpl
        extends AbstractServiceImpl<UserAddress, UserAddressRepositoryApi>
        implements UserAddressServiceApi {

    @Autowired
    private UserRepositoryApi userRepository;

    @Override
    public Page<UserAddress> getUserAddresses(Long userId, Pageable pageable) {
        return repository.findByUser(userId, pageable);
    }

    @Override
    public UserAddress getAddressByUser(Long userId, Long addressId) {
        return repository.findByUserAndId(userId, addressId);
    }

    @Override
    public UserAddress addAddressToUser(Long userId, UserAddress address) {
        User user = userRepository.getOne(userId);
        address.setUser(user);
        return repository.save(address);
    }

    @Override
    public void deleteAddress(Long userId, Long addressId) {
        repository.deleteByUserAndId(userId, addressId);
    }
}