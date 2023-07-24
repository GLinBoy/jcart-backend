package com.glinboy.jcart.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.glinboy.jcart.model.UserAddress;

public interface UserAddressRepositoryApi extends JpaRepository<UserAddress, Long> {
	Page<UserAddress> findByUser(Long userId, Pageable pageable);

	Optional<UserAddress> findByUserIdAndId(Long userId, Long addressId);

	@Modifying
	void deleteByUserIdAndId(Long userId, Long addressId);
}
