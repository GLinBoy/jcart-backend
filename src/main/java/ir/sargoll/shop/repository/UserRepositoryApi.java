package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepositoryApi extends JpaRepository<User, Long> {
}
