package com.glinboy.jcart.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.ResourceNotFoundException;
import com.glinboy.jcart.model.User;
import com.glinboy.jcart.model.UserAddress;
import com.glinboy.jcart.repository.UserAddressRepositoryApi;
import com.glinboy.jcart.repository.UserRepositoryApi;
import com.glinboy.jcart.service.UserAddressServiceApi;
import com.glinboy.jcart.service.dto.UserAddressDTO;
import com.glinboy.jcart.service.mapper.UserAddressMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserAddressServiceImpl
		extends AbstractServiceImpl<UserAddressDTO, UserAddress, UserAddressMapper, UserAddressRepositoryApi>
		implements UserAddressServiceApi {

	private final UserRepositoryApi userRepository;

	public UserAddressServiceImpl(UserAddressRepositoryApi repository, UserAddressMapper userAddressMapper,
			UserRepositoryApi userRepository) {
		super(repository, userAddressMapper);
		this.userRepository = userRepository;
	}

	@Override
	public Page<UserAddressDTO> getUserAddresses(Long userId, Pageable pageable) {
		return repository.findByUser(userId, pageable).map(mapper::toDto);
	}

	@Override
	public UserAddressDTO getAddressByUser(Long userId, Long addressId) {
		return repository.findByUserAndId(userId, addressId).map(mapper::toDto)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found id = " + addressId));
	}

	@Override
	public UserAddressDTO addAddressToUser(Long userId, UserAddressDTO addressDTO) {
		UserAddress address = mapper.toEntity(addressDTO);
		User user = userRepository.getById(userId);
		address.setUser(user);
		return mapper.toDto(repository.save(address));
	}

	@Override
	public void deleteAddress(Long userId, Long addressId) {
		repository.deleteByUserAndId(userId, addressId);
	}
}
