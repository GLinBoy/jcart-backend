package ir.sargoll.shop.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import ir.sargoll.shop.controller.UserPrincipal;

@Component
public class DataGuard {

    public boolean checkUserId(Authentication authentication, Long id) {
    	UserPrincipal user = ((UserPrincipal)authentication.getPrincipal());
        return (user.getId().equals(id) || user.getAuthorities().stream()
        		.anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")));
    }
}