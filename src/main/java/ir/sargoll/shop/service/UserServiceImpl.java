package ir.sargoll.shop.service;

import ir.sargoll.shop.model.User;
import ir.sargoll.shop.repository.UserRepositoryApi;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends AbstractServiceImpl<User, UserRepositoryApi> implements UserServiceApi {
}
