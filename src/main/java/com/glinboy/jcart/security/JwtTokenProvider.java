package com.glinboy.jcart.security;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.glinboy.jcart.model.UserPrincipal;
import com.glinboy.jcart.util.ApplicationProperties;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtTokenProvider {

	public static final String ROLES_CLAIM_NAME = "roles";

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

	private static final int ONE_MONTH_IN_SECOUND = 2_592_000;

	private final ApplicationProperties properties;

	private final JwtParser jwtParser;
	
	private final Key key;
	
	public JwtTokenProvider(ApplicationProperties properties) {
		this.properties = properties;
		this.jwtParser = Jwts.parserBuilder()
				.setSigningKey(Decoders.BASE64.decode(properties.getSecurity().getJwt().getBase64Secret()))
				.build();
		this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(properties.getSecurity().getJwt().getBase64Secret()));
	}

	public Authentication getAuthentication(String token) {
		Claims claims = (Claims) jwtParser.parse(token).getBody();
		var authorities = Arrays.asList(claims.get(ROLES_CLAIM_NAME)
		.toString()
		.split(","))
		.stream().filter(StringUtils::isNotBlank)
		.map(SimpleGrantedAuthority::new)
		.toList();
		var principal = new User(claims.getSubject(), "", authorities);
		return new UsernamePasswordAuthenticationToken(principal, token, authorities);
	}

	private String generateToken(Authentication authentication, Boolean rememberMe) {
		Date expiryDate = new Date(
				new Date().getTime() +
				(rememberMe.booleanValue() ? ONE_MONTH_IN_SECOUND :
					properties.getSecurity().getJwt().getExpirationInSecound()) * 1000L);
		final List<String> authorities = authentication
				.getAuthorities()
				.stream()
				.map(GrantedAuthority::getAuthority)
				.toList();
		
		return Jwts.builder()
				.setSubject(((UserPrincipal) authentication.getPrincipal()).getEmail())
				.claim(ROLES_CLAIM_NAME, authorities)
				.setIssuedAt(new Date())
				.setExpiration(expiryDate)
				.signWith(key, SignatureAlgorithm.HS512)
				.compact();
	}

	public void setTokenOnResponse(Authentication authentication, Boolean rememberMe, HttpServletResponse response) {
		Cookie cookie = new Cookie(properties.getSecurity().getJwt().getTokenName(), generateToken(authentication, rememberMe));
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(rememberMe.booleanValue() ? ONE_MONTH_IN_SECOUND :
			properties.getSecurity().getJwt().getExpirationInSecound());
		response.addCookie(cookie);
	}

	public String getUserIdFromJWT(String token) {
		return jwtParser.parseClaimsJws(token).getBody().getSubject();
	}

	public String getTokenFromCookie(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if(StringUtils.isBlank(bearerToken) &&
				WebUtils.getCookie(request, properties.getSecurity().getJwt().getTokenName()) != null &&
				StringUtils.isNotBlank(WebUtils.getCookie(request, properties.getSecurity().getJwt().getTokenName()).getValue())) {
			bearerToken = WebUtils.getCookie(request, properties.getSecurity().getJwt().getTokenName()).getValue();
		}
		if (StringUtils.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return bearerToken;
	}

	public boolean validateToken(String authToken) {
		try {
			jwtParser.parseClaimsJws(authToken);
			return true;
		} catch (SecurityException ex) {
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
		Cookie cookie = new Cookie(properties.getSecurity().getJwt().getTokenName(), null);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
//        cookie.setSecure(true);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
