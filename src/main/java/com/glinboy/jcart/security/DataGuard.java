package com.glinboy.jcart.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.glinboy.jcart.model.UserPrincipal;

@Component
public class DataGuard {

	public boolean checkUserId(Authentication authentication, Long id) {
		if (authentication.getPrincipal() instanceof UserPrincipal userPrincipal) {
			return (userPrincipal.getId().equals(id)
					|| userPrincipal.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")));
		} else {
			return false;
		}
	}
}