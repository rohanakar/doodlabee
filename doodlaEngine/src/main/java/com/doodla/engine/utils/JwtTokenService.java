package com.doodla.engine.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.doodla.engine.model.Users;
import com.doodla.engine.repositories.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenService implements Serializable {
	
	private static final long serialVersionUID = -2550185165626007488L;
	public static final long JWT_TOKEN_VALIDITY = 24*60*60*30;
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Autowired
	private UserRepository userRepository;

	public String getIdFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	public Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public String generateToken(Users user) {
		return Jwts.builder()
				.setSubject(user.getId()+"")
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}


	public boolean validateToken(String token) {
	    String _id = getIdFromToken(token);
	    Users user = null;
	    try{
	    	user = userRepository.findById(Long.parseLong(_id)).get();
	    }catch(Exception e) {}
		return user!=null;
	}
	
}