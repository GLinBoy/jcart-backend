package com.glinboy.jcart.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.jcart.model.UserTransaction;

public interface UserTransactionServiceApi extends GenericService<UserTransaction> {

    Page<UserTransaction> findUserTransactions(Long userId, Pageable pageable);
    Optional<UserTransaction> findByUserAndTransaction(Long userId, Long transactionId);

}