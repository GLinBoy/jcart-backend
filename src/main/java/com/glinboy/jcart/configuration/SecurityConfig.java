package com.glinboy.jcart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;

import com.glinboy.jcart.security.CsrfHeaderFilter;
import com.glinboy.jcart.security.CustomUserDetailsService;
import com.glinboy.jcart.security.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig {
	
	private static final String[] AUTH_WHITELIST = {
			"/",
			"/auth/**",
			"/users/checkEmailAvailability",
			"/h2-console/**",
			// -- Swagger UI v2
			"/v2/api-docs",
			"/swagger-resources",
			"/swagger-resources/**",
			"/configuration/ui",
			"/configuration/security",
			"/swagger-ui.html",
			"/webjars/**",
			// -- Swagger UI v3 (OpenAPI)
			"/v3/api-docs/**",
			"/swagger-ui/**"
			// other public endpoints of your API may be appended to this array
	};

	private final CustomUserDetailsService customUserDetailsService;
	
	private final SecurityProblemSupport problemSupport;

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

	@Bean
	public DaoAuthenticationConfigurer<AuthenticationManagerBuilder, CustomUserDetailsService> configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		return authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		http.cors().and().csrf().disable()
			.exceptionHandling()
			.authenticationEntryPoint(problemSupport)
			.accessDeniedHandler(problemSupport)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeHttpRequests(requests -> requests
//					.requestMatchers("/users/{user_id}/**")
//					.access("@dataGuard.checkUserId(authentication,#user_id)")
					.requestMatchers(AUTH_WHITELIST).permitAll()
					.anyRequest().authenticated()
				);
		// Add our custom JWT security filter
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		http.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
		return http.build();
	}
}
