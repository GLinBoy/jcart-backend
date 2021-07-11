package com.glinboy.jcart.service;

import com.glinboy.jcart.model.User;
import com.glinboy.jcart.service.dto.UserDTO;

public interface UserServiceApi extends GenericService<UserDTO> {

	User register(UserDTO user);

	void recoveryByMail(String mail);

	void recoveryByMobile(String phoneNumber);
}
