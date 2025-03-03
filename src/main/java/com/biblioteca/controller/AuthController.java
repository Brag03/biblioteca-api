package com.biblioteca.controller;

import com.biblioteca.dto.LoginDTO;
import com.biblioteca.dto.AuthResponseDTO;
import com.biblioteca.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
   @Autowired
   private AuthService authService;
   @PostMapping("/login")
   public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
       AuthResponseDTO response = authService.login(loginDTO);
       return ResponseEntity.ok(response);
   }
}