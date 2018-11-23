package ir.sargoll.shop.controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ir.sargoll.shop.ApiResponse;
import ir.sargoll.shop.exception.AppException;
import ir.sargoll.shop.model.User;
import ir.sargoll.shop.model.UserGender;
import ir.sargoll.shop.model.UserGroup;
import ir.sargoll.shop.repository.UserGroupRepositoryApi;
import ir.sargoll.shop.repository.UserRepositoryApi;
import ir.sargoll.shop.security.JwtAuthenticationResponse;
import ir.sargoll.shop.security.JwtTokenProvider;
import ir.sargoll.shop.security.LoginRequest;
import ir.sargoll.shop.security.SignUpRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepositoryApi userRepository;

    @Autowired
    UserGroupRepositoryApi userGroupRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmailOrMobile(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
        	return ResponseEntity.badRequest()
        			.body(new ApiResponse(false, "Email Address already in use!"));
        }

        // Creating user's account
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setFamily(signUpRequest.getFamily());
        user.setEmail(signUpRequest.getEmail());
        user.setMobile(signUpRequest.getMobile());
        user.setGender(UserGender.valueOf(signUpRequest.getGender()));
        user.setCreatedBy(1L);
        user.setEditedBy(1L);
        // FIXME by default, Must Not be activated
        user.setIsActive(Boolean.TRUE);
        // FIXME Generate user code for introducing
        user.setCodeIntroducing("ABC-123");

//        user.setPassword(signUpRequest.getPassword());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        UserGroup userGroup = userGroupRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setGroups(Collections.singletonList(userGroup));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getEmail()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}