package ir.sargoll.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.UserAddress;

public interface UserAddressRepositoryApi extends JpaRepository<UserAddress, Long> {
    Page<UserAddress> findByUser(Long userId, Pageable pageable);
    UserAddress findByUserAndId(Long userId, Long addressId);
    void deleteByUserAndId(Long userId, Long addressId);
}
