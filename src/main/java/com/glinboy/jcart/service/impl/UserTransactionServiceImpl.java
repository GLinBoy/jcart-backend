package com.glinboy.jcart.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.glinboy.jcart.model.UserTransaction;
import com.glinboy.jcart.repository.UserTransactionRepositoryApi;
import com.glinboy.jcart.service.UserTransactionServiceApi;
import com.glinboy.jcart.service.dto.UserTransactionDTO;
import com.glinboy.jcart.service.mapper.UserTransactionMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserTransactionServiceImpl extends
		AbstractServiceImpl<UserTransactionDTO, UserTransaction, UserTransactionMapper, UserTransactionRepositoryApi>
		implements UserTransactionServiceApi {

	public UserTransactionServiceImpl(UserTransactionRepositoryApi repository, UserTransactionMapper mapper) {
		super(repository, mapper);
	}

	@Override
	public Page<UserTransactionDTO> findUserTransactions(Long userId, Pageable pageable) {
		return repository.findAllByUser_Id(userId, pageable).map(mapper::toDto);
	}

	@Override
	public Optional<UserTransactionDTO> findByUserAndTransaction(Long userId, Long transactionId) {
		return repository.findByIdAndUser_Id(userId, transactionId).map(mapper::toDto);
	}
}
