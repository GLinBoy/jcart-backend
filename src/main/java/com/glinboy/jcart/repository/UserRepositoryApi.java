package com.glinboy.jcart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.User;

public interface UserRepositoryApi extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByMobile(String mobile);

    Optional<User> findByEmailOrMobile(String email, String mobile);

    Boolean existsByEmail(String email);
}
