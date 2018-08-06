package ir.sargoll.shop.service;

import ir.sargoll.shop.model.ResourceNotFoundException;
import ir.sargoll.shop.model.User;
import ir.sargoll.shop.repository.UserRepositoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl extends AbstractServiceImpl<User, UserRepositoryApi> implements UserServiceApi {

//    @Autowired
//    private UserRepositoryApi userRepository;

    @Override
    public User register(User user) {
        return repository.save(user);
    }

    @Override
    public void recoveryByMail(String mail) {
        Optional<User> userOptional = repository.findUserByEmail(mail);
    }

    @Override
    public void recoveryByMobile(String mobile) {
        Optional<User> userOptional = repository.findUserByMobile(mobile);
    }

    @Override
    public void deleteSingleById(Long id) {
        User user = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not found with id = " + id));
        user.setIsDeleted(Boolean.TRUE);
        repository.save(user);
    }
}
