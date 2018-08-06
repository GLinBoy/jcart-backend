package ir.sargoll.shop.service;

import ir.sargoll.shop.model.User;

public interface UserServiceApi extends GenericService<User> {

    User register(User user);
    void recoveryByMail(String mail);
    void recoveryByMobile(String phoneNumber);
}
