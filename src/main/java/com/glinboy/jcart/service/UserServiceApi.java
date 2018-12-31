package com.glinboy.jcart.service;

import com.glinboy.jcart.model.User;

public interface UserServiceApi extends GenericService<User> {

    User register(User user);
    void recoveryByMail(String mail);
    void recoveryByMobile(String phoneNumber);
}
