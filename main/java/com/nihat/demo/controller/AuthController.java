package com.nihat.demo.controller;

import com.nihat.demo.model.User;
import com.nihat.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Frontend rahat qoşulsun deyə
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Bu istifadəçi adı artıq mövcuddur!");
        }
        userRepository.save(user);
        return ResponseEntity.ok("Qeydiyyat uğurla tamamlandı!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> dbUser = userRepository.findByUsername(user.getUsername());

        if (dbUser.isPresent() && dbUser.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(dbUser.get());
        }
        return ResponseEntity.status(401).body("İstifadəçi adı və ya şifrə yanlışdır!");
    }
}