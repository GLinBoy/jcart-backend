package com.glinboy.jcart.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.glinboy.jcart.service.UserServiceApi;

import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtTokenProvider tokenProvider;

	private final UserServiceApi userService;

	private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = getJwtFromRequest(request);

			if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
				String email = tokenProvider.getUserIdFromJWT(jwt);

				UserDetails userDetails = userService.loadUserByUsername(email);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (SignatureException ex) {
			// JWT signature validation failed - this is expected for invalid/tampered tokens
			log.debug("JWT signature validation failed for request to {}: {}", request.getRequestURI(), ex.getMessage());
		} catch (ExpiredJwtException ex) {
			// JWT expired - this is expected behavior
			log.debug("JWT token expired for request to {}: {}", request.getRequestURI(), ex.getMessage());
		} catch (MalformedJwtException ex) {
			// JWT malformed - log as warning since this could indicate an attack
			log.warn("Malformed JWT token for request to {}: {}", request.getRequestURI(), ex.getMessage());
		} catch (UnsupportedJwtException ex) {
			// JWT not supported - log as warning
			log.warn("Unsupported JWT token for request to {}: {}", request.getRequestURI(), ex.getMessage());
		} catch (IllegalArgumentException ex) {
			// JWT claims string is empty - this is expected when no token is provided
			log.debug("Empty JWT claims for request to {}: {}", request.getRequestURI(), ex.getMessage());
		} catch (Exception ex) {
			// Any other unexpected exception should still be logged as error
			log.error("Unexpected error during JWT authentication for request to {}: {}", request.getRequestURI(), ex.getMessage(), ex);
		}

		filterChain.doFilter(request, response);
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		return tokenProvider.getTokenFromCookie(request);
	}
}
