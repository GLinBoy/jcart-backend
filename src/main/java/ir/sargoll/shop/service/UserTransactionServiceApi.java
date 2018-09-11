package ir.sargoll.shop.service;

import ir.sargoll.shop.model.UserTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserTransactionServiceApi extends GenericService<UserTransaction> {

    Page<UserTransaction> findUserTransactions(Long userId, Pageable pageable);
    Optional<UserTransaction> findByUserAndTransaction(Long userId, Long transactionId);

}
