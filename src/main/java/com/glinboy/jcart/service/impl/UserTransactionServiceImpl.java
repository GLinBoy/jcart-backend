package com.glinboy.jcart.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.UserTransaction;
import com.glinboy.jcart.repository.UserTransactionRepositoryApi;
import com.glinboy.jcart.service.UserTransactionServiceApi;

@Service
@Transactional
public class UserTransactionServiceImpl extends AbstractServiceImpl<UserTransaction, UserTransactionRepositoryApi>
		implements UserTransactionServiceApi {
	
	public UserTransactionServiceImpl(UserTransactionRepositoryApi repository) {
		super(repository);
	}

	@Override
	public Page<UserTransaction> findUserTransactions(Long userId, Pageable pageable) {
		return repository.findAllByUser_Id(userId, pageable);
	}

	@Override
	public Optional<UserTransaction> findByUserAndTransaction(Long userId, Long transactionId) {
		return repository.findByIdAndUser_Id(userId, transactionId);
	}
}
