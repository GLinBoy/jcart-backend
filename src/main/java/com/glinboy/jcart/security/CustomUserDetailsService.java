package com.glinboy.jcart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glinboy.jcart.model.User;
import com.glinboy.jcart.model.UserPrincipal;
import com.glinboy.jcart.repository.UserRepositoryApi;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepositoryApi userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String maileOrMobile)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        User user = userRepository.findByEmailOrMobile(maileOrMobile, maileOrMobile)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with Email or Mobile: " + maileOrMobile)
                );

        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return UserPrincipal.create(user);
    }
}
