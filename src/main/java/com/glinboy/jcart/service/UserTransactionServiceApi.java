package com.glinboy.jcart.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.jcart.service.dto.UserTransactionDTO;

public interface UserTransactionServiceApi extends GenericService<UserTransactionDTO> {

	Page<UserTransactionDTO> findUserTransactions(Long userId, Pageable pageable);

	Optional<UserTransactionDTO> findByUserAndTransaction(Long userId, Long transactionId);

}
