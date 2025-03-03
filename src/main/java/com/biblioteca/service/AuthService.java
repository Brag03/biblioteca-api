package com.biblioteca.service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biblioteca.dto.AuthResponseDTO;
import com.biblioteca.dto.LoginDTO;
import com.biblioteca.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Service
public class AuthService {
   @Autowired
   private AuthenticationManager authenticationManager;
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private PasswordEncoder passwordEncoder;
   private final String SECRET_KEY = "bibliotecaSecret"; // 🔐 Chave para assinar o token JWT
   public AuthResponseDTO login(LoginDTO loginDTO) {
       Authentication authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
       );
       SecurityContextHolder.getContext().setAuthentication(authentication);
       String token = generateToken(loginDTO.getEmail());
       return new AuthResponseDTO(token);
   }
   private Key getSigningKey() {
	   return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
	}
	private String generateToken(String email) {
	   return Jwts.builder()
	           .setSubject(email)
	           .setIssuedAt(new Date())
	           .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24 horas
	           .signWith(getSigningKey(), SignatureAlgorithm.HS256)
	           .compact();
	}
}
