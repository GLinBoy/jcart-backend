package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserGroupRepositoryApi extends JpaRepository<UserGroup, Long> {
    Optional<UserGroup> findByName(String groupName);
}
