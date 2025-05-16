package com.example.jwtapi.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class AuthRequest {
    @NotBlank(message = "ユーザーIDは必須です")
    private String userId;
    
    @NotBlank(message = "パスワードは必須です")
    private String password;
}
