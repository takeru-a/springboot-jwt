package com.example.jwtapi.servicecontroller;

import com.example.jwtapi.dto.AuthRequest;
import com.example.jwtapi.dto.AuthResponse;
import com.example.jwtapi.exception.CustomException;
import com.example.jwtapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AuthServiceController {
    
    private final AuthService authService;
    
    @Transactional(readOnly = true)
    public AuthResponse authenticate(AuthRequest request) {
        try {
            return authService.authenticate(request.getUserId(), request.getPassword());
        } catch (Exception e) {
            throw new CustomException("認証に失敗しました: " + e.getMessage(), 401);
        }
    }
}
