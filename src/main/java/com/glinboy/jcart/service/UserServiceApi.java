package com.glinboy.jcart.service;

import com.glinboy.jcart.service.dto.UserDTO;

public interface UserServiceApi extends GenericService<UserDTO> {

	UserDTO register(UserDTO user);

	void recoveryByMail(String mail);

	void recoveryByMobile(String phoneNumber);
}
