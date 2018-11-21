package ir.sargoll.shop.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ir.sargoll.shop.model.UserTransaction;
import ir.sargoll.shop.repository.UserTransactionRepositoryApi;

@Service
@Transactional
public class UserTransactionServiceImpl
        extends AbstractServiceImpl<UserTransaction, UserTransactionRepositoryApi>
        implements UserTransactionServiceApi {
    @Override
    public Page<UserTransaction> findUserTransactions(Long userId, Pageable pageable) {
        return repository.findAllByUser_Id(userId, pageable);
    }

    @Override
    public Optional<UserTransaction> findByUserAndTransaction(Long userId, Long transactionId) {
        return repository.findByIdAndUser_Id(userId, transactionId);
    }
}
