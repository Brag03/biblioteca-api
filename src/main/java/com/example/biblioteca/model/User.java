package com.example.biblioteca.model;

import java.util.Set;

import javax.management.relation.Role;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(nullable = false)
   private String name;
   @Column(unique = true, nullable = false)
   private String email;
   @Column(nullable = false)
   private String password;
   @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
   @Enumerated(EnumType.STRING)
   @CollectionTable(name = "user_roles")
   @Column(name = "role")
   private Set<Role> roles;
   
// ✅ Construtor vazio
   public User() {}
   // ✅ Getters e Setters
   public Long getId() {
       return id;
   }
   public void setId(Long id) {
this.id = id;
   }
   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public String getEmail() {
       return email;
   }
   public void setEmail(String email) {
       this.email = email;
   }
   public String getPassword() {
       return password;
   }
   public void setPassword(String password) {
       this.password = password;
   }
   public Set<Role> getRoles() {
       return roles;
   }
   public void setRoles(Set<Role> roles) {
       this.roles = roles;
   }
}