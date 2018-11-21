package ir.sargoll.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.User;

public interface UserRepositoryApi extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByMobile(String mobile);

    Optional<User> findByEmailOrMobile(String email, String mobile);

    Boolean existsByEmail(String email);
}
