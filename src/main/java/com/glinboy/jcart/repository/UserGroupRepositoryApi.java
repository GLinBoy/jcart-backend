package com.glinboy.jcart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.UserGroup;

public interface UserGroupRepositoryApi extends JpaRepository<UserGroup, Long> {
    Optional<UserGroup> findByName(String groupName);
}
