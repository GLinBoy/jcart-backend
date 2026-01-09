package com.glinboy.jcart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;

import com.glinboy.jcart.security.CsrfHeaderFilter;
import com.glinboy.jcart.security.JwtAuthenticationFilter;
import com.glinboy.jcart.security.JwtTokenProvider;
import com.glinboy.jcart.service.UserServiceApi;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
	
	private final UserServiceApi userService;
	private final JwtTokenProvider jwtTokenProvider;
	
	private static final String[] AUTH_WHITELIST = {
			"/",
			"/auth/**",
			"/users/checkEmailAvailability",
			"/h2-console/**",
			// -- Swagger UI v3 (OpenAPI)
			"/swagger-ui.html",
			"/v3/api-docs/**",
			"/swagger-ui/**"
			// other public endpoints of your API may be appended to this array
	};

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) {
		return http
				.cors(AbstractHttpConfigurer::disable)
				.csrf(AbstractHttpConfigurer::disable)
				.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(AUTH_WHITELIST)
						.permitAll()
						.anyRequest().authenticated()
					)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider, userService), UsernamePasswordAuthenticationFilter.class)
				.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
				.userDetailsService(userService)
				.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) {
		try {
			return authenticationConfiguration.getAuthenticationManager();
		} catch (Exception e) {
			throw new RuntimeException("Failed to create AuthenticationManager", e);
		}
	}
}
