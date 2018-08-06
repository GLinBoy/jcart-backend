package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.UserAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepositoryApi extends JpaRepository<UserAddress, Long> {
    Page<UserAddress> findbyUser(Long userId);
}
