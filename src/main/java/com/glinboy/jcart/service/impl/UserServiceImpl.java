package com.glinboy.jcart.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glinboy.jcart.model.ResourceNotFoundException;
import com.glinboy.jcart.model.User;
import com.glinboy.jcart.model.UserPrincipal;
import com.glinboy.jcart.repository.UserRepositoryApi;
import com.glinboy.jcart.service.UserServiceApi;
import com.glinboy.jcart.service.dto.UserDTO;
import com.glinboy.jcart.service.mapper.UserMapper;

@Service
@Transactional
public class UserServiceImpl extends AbstractServiceImpl<UserDTO, User, UserMapper, UserRepositoryApi>
		implements UserServiceApi {

	public UserServiceImpl(UserRepositoryApi repository, UserMapper mapper) {
		super(repository, mapper);
	}

	@Override
	public UserDTO register(UserDTO userDTO) {
		User user = mapper.toEntity(userDTO);
		return mapper.toDto(repository.save(user));
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

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String maileOrMobile) throws UsernameNotFoundException {
		// Let people login with either username or email
		User user = repository.findByEmailOrMobile(maileOrMobile, maileOrMobile).orElseThrow(
				() -> new UsernameNotFoundException("User not found with Email or Mobile: " + maileOrMobile));

		return UserPrincipal.create(user);
	}

	// This method is used by JWTAuthenticationFilter
	@Transactional
	public UserDetails loadUserById(Long id) {
		User user = repository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));

		return UserPrincipal.create(user);
	}
}
