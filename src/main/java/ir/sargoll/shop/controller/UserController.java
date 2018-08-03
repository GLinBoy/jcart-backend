package ir.sargoll.shop.controller;

import ir.sargoll.shop.model.User;
import ir.sargoll.shop.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController extends BaseController<User> {

    @Autowired
    private UserServiceApi userService;

    @GetMapping
    public Page<User> getUsers(Pageable pageable) {
        return userService.getAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getSingleById(id);
    }
}
