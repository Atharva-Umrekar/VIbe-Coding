package com.example.hospital.controller;

import com.example.hospital.model.AppUser;
import com.example.hospital.repository.AppUserRepository;
import com.example.hospital.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AppUserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(AppUserRepository userRepo, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody Map<String, Object> payload) {
        String username = (String) payload.get("username");
        String password = (String) payload.get("password");
        String role = (String) payload.get("role"); // ROLE_PATIENT / ROLE_DOCTOR / ROLE_HOSPITAL

        if (userRepo.findByUsername(username).isPresent()) throw new IllegalArgumentException("User exists");

        AppUser u = AppUser.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(Set.of(role))
                .build();
        return userRepo.save(u);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String password = payload.get("password");
        AppUser u = userRepo.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Bad credentials"));
        if (!passwordEncoder.matches(password, u.getPassword())) throw new IllegalArgumentException("Bad credentials");
        String token = jwtUtil.generateToken(username, u.getRoles());
        return Map.of("token", token);
    }

    @PostMapping("/logout")
    public Map<String, String> logout() {
        // With JWT stateless auth there is no server-side logout unless using token blacklist.
        return Map.of("message", "Logout: discard the token on client side or implement a blacklist if needed");
    }
}
