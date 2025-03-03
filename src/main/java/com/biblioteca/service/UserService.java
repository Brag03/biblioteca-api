package com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.repository.UserRepository;
import com.example.biblioteca.model.User;
@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;
   // ✅ Buscar todos os usuários
   public List<User> getAllUsers() {
       return userRepository.findAll();
   }
   // ✅ Buscar um usuário pelo ID
   public Optional<User> getUserById(Long id) {
       return userRepository.findById(id);
   }
   // ✅ Criar um novo usuário
   public User createUser(User user) {
       return userRepository.save(user);
   }
   // ✅ Atualizar um usuário existente
   public User updateUser(Long id, User userDetails) {
       Optional<User> optionalUser = userRepository.findById(id);
       if (optionalUser.isPresent()) {
           User user = optionalUser.get();
           user.setName(userDetails.getName());
           user.setEmail(userDetails.getEmail());
           user.setPassword(userDetails.getPassword());
           user.setRoles(userDetails.getRoles());
           return userRepository.save(user);
       }
       return null;
   }
   // ✅ Excluir um usuário
   public boolean deleteUser(Long id) {
       if (userRepository.existsById(id)) {
           userRepository.deleteById(id);
           return true;
       }
       return false;
   }
}