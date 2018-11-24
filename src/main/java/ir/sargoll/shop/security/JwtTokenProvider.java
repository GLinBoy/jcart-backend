package ir.sargoll.shop.security;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import ir.sargoll.shop.model.UserPrincipal;

@Component
public class JwtTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${app.jwt.Secret}")
    private String jwtSecret;

    @Value("${app.jwt.ExpirationInMs}")
    private int jwtExpirationInMs;
    
    @Value("${app.jwt.TokenName}")
    private String jwtTokenName;

    private String generateToken(Authentication authentication) {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
    
    public void setTokenOnResponse(Authentication authentication, HttpServletResponse response) {
        Cookie cookie = new Cookie(jwtTokenName, generateToken(authentication));
        cookie.setPath("/");
        cookie.setHttpOnly(true);
//        cookie.setSecure(true);
        response.addCookie(cookie);
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

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
