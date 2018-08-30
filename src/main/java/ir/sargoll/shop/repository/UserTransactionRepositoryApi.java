package ir.sargoll.shop.repository;

import ir.sargoll.shop.model.UserTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTransactionRepositoryApi extends JpaRepository<UserTransaction, Long> {

    Page<UserTransaction> findAllByUser_Id(Long userId, Pageable pageable);
    Optional<UserTransaction> findByIdAndUser_Id(Long userId, Long transactionId);

}
