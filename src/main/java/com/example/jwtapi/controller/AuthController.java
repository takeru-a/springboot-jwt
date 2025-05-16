package com.example.jwtapi.controller;

import com.example.jwtapi.dto.AuthRequest;
import com.example.jwtapi.dto.AuthResponse;
import com.example.jwtapi.servicecontroller.AuthServiceController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthServiceController authServiceController;
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest request) {
        return ResponseEntity.ok(authServiceController.authenticate(request));
    }
}
