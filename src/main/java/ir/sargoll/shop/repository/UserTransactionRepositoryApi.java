package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTransactionRepositoryApi extends JpaRepository<UserTransaction, Long> {
}
