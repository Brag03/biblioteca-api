package com.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.service.UserService;
import com.example.biblioteca.model.User;
@RestController
@RequestMapping("/api/users")
public class UserController {
   @Autowired
   private UserService userService;
   // ✅ GET - Listar todos os usuários
   @GetMapping
   public List<User> getAllUsers() {
       return userService.getAllUsers();
   }
   // ✅ GET - Buscar um usuário por ID
   @GetMapping("/{id}")
   public ResponseEntity<User> getUserById(@PathVariable Long id) {
       Optional<User> user = userService.getUserById(id);
       return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }
   // ✅ POST - Criar um novo usuário
   @PostMapping
   public User createUser(@RequestBody User user) {
       return userService.createUser(user);
   }
   // ✅ PUT - Atualizar um usuário existente
   @PutMapping("/{id}")
   public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
       User updatedUser = userService.updateUser(id, userDetails);
       return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
   }
   // ✅ DELETE - Excluir um usuário pelo ID
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
       return userService.deleteUser(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
   }
}