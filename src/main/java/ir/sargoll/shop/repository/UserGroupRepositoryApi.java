package ir.sargoll.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.sargoll.shop.model.UserGroup;

public interface UserGroupRepositoryApi extends JpaRepository<UserGroup, Long> {
    Optional<UserGroup> findByName(String groupName);
}
