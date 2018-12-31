package com.glinboy.jcart.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.jcart.model.UserTransaction;

public interface UserTransactionRepositoryApi extends JpaRepository<UserTransaction, Long> {

    Page<UserTransaction> findAllByUser_Id(Long userId, Pageable pageable);
    Optional<UserTransaction> findByIdAndUser_Id(Long userId, Long transactionId);

}
