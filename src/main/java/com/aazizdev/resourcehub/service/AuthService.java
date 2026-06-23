package com.aazizdev.resourcehub.service;

import com.aazizdev.resourcehub.dto.*;
import com.aazizdev.resourcehub.entity.User;
import com.aazizdev.resourcehub.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    public AuthService(UserRepository UserRepository, PasswordEncoder passwordEncoder){
        this.userRepository = UserRepository;

        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public AuthResponse register(RegisterRequest request){

        if (userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email already exist");
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");
        user.setStatus(true);
        user.setJoinedDate(Instant.now());
        userRepository.save(user);


        if (request.getRole().equals("USER")){
            user.setRole("USER");

        } else {
            user.setRole("ADMIN");
        }

        return new AuthResponse("Registration successful", user.getFullName(), user.getRole());
    }


    public AuthResponse login(LoginRequest request){

        User user = userRepository.findByEmail(request.getEmail()).orElse(null);

        if (userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Invalid email or password");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }

        return new AuthResponse("Login Successful", user.getEmail(), user.getRole());
    }

    public Map<String, String> forgetPassword(ForgetPassword request){
        userRepository.findByEmail(request.getEmail());
        Map<String, String> response = new HashMap<>();
        response.put("message", "If registered, check your email for a reset link.");
        return response;
    }

    public UserProfileResponse getProfileByEmail(String email){
        User user = userRepository.findByEmail(email).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        UserProfileResponse profile = new UserProfileResponse();
        profile.setUserId(user.getUser());
        profile.setFullName(user.getFullName());
        profile.setEmail(user.getEmail());
        profile.setRole(user.getRole());
        profile.setStatus(user.getStatus());

        return profile;
    }
}
