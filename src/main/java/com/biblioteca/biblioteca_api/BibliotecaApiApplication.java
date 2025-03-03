package com.biblioteca.biblioteca_api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@SpringBootApplication
@EntityScan("com.example.biblioteca.model") // Garante que as entidades sejam reconhecidas
@EnableJpaRepositories("com.example.biblioteca.repository") // Escaneia os repositórios
public class BibliotecaApiApplication {
   public static void main(String[] args) {
       SpringApplication.run(BibliotecaApiApplication.class, args);
   }
}