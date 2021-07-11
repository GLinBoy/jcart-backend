package com.glinboy.jcart.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.jcart.service.dto.UserAddressDTO;

public interface UserAddressServiceApi extends GenericService<UserAddressDTO> {
	Page<UserAddressDTO> getUserAddresses(Long userId, Pageable pageable);

	UserAddressDTO getAddressByUser(Long userId, Long addressId);

	UserAddressDTO addAddressToUser(Long userId, UserAddressDTO address);

	void deleteAddress(Long userId, Long addressId);
}
