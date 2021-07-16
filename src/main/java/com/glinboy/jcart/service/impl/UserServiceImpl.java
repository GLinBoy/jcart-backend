package com.glinboy.jcart.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glinboy.jcart.model.ResourceNotFoundException;
import com.glinboy.jcart.model.User;
import com.glinboy.jcart.repository.UserRepositoryApi;
import com.glinboy.jcart.service.UserServiceApi;
import com.glinboy.jcart.service.dto.UserDTO;
import com.glinboy.jcart.service.mapper.UserMapper;

@Service
@Transactional
public class UserServiceImpl extends AbstractServiceImpl<UserDTO, User, UserMapper, UserRepositoryApi> implements UserServiceApi {

	public UserServiceImpl(UserRepositoryApi repository, UserMapper mapper) {
		super(repository, mapper);
	}

	@Override
	public User register(User user) {
		return repository.save(user);
	}

	@Override
	public void recoveryByMail(String mail) {
//        User user = repository.findUserByEmail(mail)
//        		.orElseThrow(() -> new ResourceNotFoundException("WRONG_CREDENTIAL"));
	}

	@Override
	public void recoveryByMobile(String mobile) {
//    	User user = repository.findUserByMobile(mobile)
//        		.orElseThrow(() -> new ResourceNotFoundException("WRONG_CREDENTIAL"));
	}

	@Override
	public void deleteSingleById(Long id) {
		User user = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id = " + id));
		user.setIsDeleted(Boolean.TRUE);
		repository.save(user);
	}
}
