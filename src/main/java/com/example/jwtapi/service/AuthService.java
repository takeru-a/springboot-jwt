package com.example.jwtapi.service;

import com.example.jwtapi.dto.AuthResponse;
import com.example.jwtapi.entity.User;
import com.example.jwtapi.exception.CustomException;
import com.example.jwtapi.repository.UserRepository;
import com.example.jwtapi.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    
    public AuthResponse authenticate(String userId, String password) {
        User user = userRepository.findByUserId(userId)
            .orElseThrow(() -> new CustomException("ユーザーが見つかりません", 404));
        
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new CustomException("パスワードが正しくありません", 401);
        }
        
        // ユーザーのロールに基づいてスコープを決定
        String scope = determineScopeByRole(user.getRole());
        String token = jwtProvider.generateToken(userId, scope);
        return new AuthResponse(token);
    }
    
    private String determineScopeByRole(String role) {
        switch (role) {
            case "ADMIN":
                return "read,update,delete,admin";
            case "EDITOR":
                return "read,update";
            case "VIEWER":
                return "read";
            default:
                return "read";
        }
    }
}
