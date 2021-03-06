package com.glinboy.jcart.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.glinboy.jcart.model.UserPrincipal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

	public static final String ROLES_CLAIM_NAME = "roles";

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

	private static final int ONE_MONTH_IN_SECOUND = 2_592_000;

	@Value("${app.jwt.Secret}")
	private String jwtSecret;

	@Value("${app.jwt.ExpirationInSecound}")
	private int jwtExpirationInSecound;

	@Value("${app.jwt.TokenName}")
	private String jwtTokenName;

	private String generateToken(Authentication authentication, Boolean rememberMe) {

		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

		Date now = new Date();
		Date expiryDate = new Date(
				now.getTime() + (rememberMe ? ONE_MONTH_IN_SECOUND : jwtExpirationInSecound) * 1000L);
		final List<String> authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
		return Jwts.builder()
				.claim(ROLES_CLAIM_NAME, authorities)
				.setSubject(userPrincipal.getUsername())
				.setIssuedAt(new Date()).setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public void setTokenOnResponse(Authentication authentication, Boolean rememberMe, HttpServletResponse response) {
		Cookie cookie = new Cookie(jwtTokenName, generateToken(authentication, rememberMe));
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(rememberMe ? ONE_MONTH_IN_SECOUND : jwtExpirationInSecound);
		response.addCookie(cookie);
	}

	public Long getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

		return Long.parseLong(claims.getSubject());
	}

	public String getTokenFromCookie(HttpServletRequest request) {
		Cookie cookie = WebUtils.getCookie(request, jwtTokenName);
		if (cookie != null) {
			return cookie.getValue();
		} else {
			return null;
		}
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
			logger.error("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			logger.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			logger.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			logger.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			logger.error("JWT claims string is empty.");
		}
		return false;
	}

	public void removeTokenOnResponse(HttpServletResponse response) {
		Cookie cookie = new Cookie(jwtTokenName, null);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
//        cookie.setSecure(true);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
