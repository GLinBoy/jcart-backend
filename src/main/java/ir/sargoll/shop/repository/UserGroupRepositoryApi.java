package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepositoryApi extends JpaRepository<UserGroup, Long> {
}
