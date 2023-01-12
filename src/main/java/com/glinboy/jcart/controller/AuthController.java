package com.glinboy.jcart.controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.glinboy.jcart.ApiResponse;
import com.glinboy.jcart.exception.AppException;
import com.glinboy.jcart.model.User;
import com.glinboy.jcart.model.UserGender;
import com.glinboy.jcart.model.UserGroup;
import com.glinboy.jcart.repository.UserGroupRepositoryApi;
import com.glinboy.jcart.repository.UserRepositoryApi;
import com.glinboy.jcart.security.JwtTokenProvider;
import com.glinboy.jcart.security.LoginRequest;
import com.glinboy.jcart.security.SignUpRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	private final UserRepositoryApi userRepository;

	private final UserGroupRepositoryApi userGroupRepository;

	private final PasswordEncoder passwordEncoder;

	private final JwtTokenProvider tokenProvider;

	@PostMapping("/signin")
	public ResponseEntity<ApiResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmailOrMobile(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		tokenProvider.setTokenOnResponse(authentication, loginRequest.getRememberMe(), response);
		return ResponseEntity
				.ok(ApiResponse.builder().login(true).success(true).message("You now are sign-in.").build());
	}

	@PostMapping("/signup")
	public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest()
					.body(ApiResponse.builder().login(false).success(false).message("Email is used!").build());
		}

		// Creating user's account
		User user = new User();
		user.setName(signUpRequest.getName());
		user.setFamily(signUpRequest.getFamily());
		user.setEmail(signUpRequest.getEmail());
		user.setMobile(signUpRequest.getMobile());
		user.setGender(UserGender.valueOf(signUpRequest.getGender()));
		user.setCreatedBy(signUpRequest.getEmail());
		user.setEditedBy(signUpRequest.getEmail());
		// FIXME by default, Must Not be activated
		user.setIsActive(Boolean.TRUE);
		// FIXME Generate user code for introducing
		user.setCodeIntroducing("ABC-123");

//        user.setPassword(signUpRequest.getPassword());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

		UserGroup userGroup = userGroupRepository.findByName("ROLE_USER")
				.orElseThrow(() -> new AppException("User Role not set."));

		user.setGroups(Collections.singletonList(userGroup));

		userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/").buildAndExpand().toUri();

		return ResponseEntity.created(location)
				.body(ApiResponse.builder().login(false).success(true).message("User registered successfully").build());
	}

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@PostMapping("/signout")
	public ResponseEntity<ApiResponse> logoutUser(HttpServletRequest request, HttpServletResponse response) {
		tokenProvider.removeTokenOnResponse(response);
		return ResponseEntity
				.ok(ApiResponse.builder().login(false).success(true).message("You now are sign-out.").build());
	}
}