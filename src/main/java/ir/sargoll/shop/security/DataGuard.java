package ir.sargoll.shop.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import ir.sargoll.shop.controller.UserPrincipal;

@Component
public class DataGuard {

    public boolean checkUserId(Authentication authentication, Long id) {
        Long userId = ((UserPrincipal)authentication.getPrincipal()).getId();
        return userId.equals(id);
    }
}