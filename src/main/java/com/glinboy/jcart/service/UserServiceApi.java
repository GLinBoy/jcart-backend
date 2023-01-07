package com.glinboy.jcart.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.glinboy.jcart.service.dto.UserDTO;

public interface UserServiceApi extends GenericService<UserDTO>, UserDetailsService {

	UserDTO register(UserDTO user);

	void recoveryByMail(String mail);

	void recoveryByMobile(String phoneNumber);
}
