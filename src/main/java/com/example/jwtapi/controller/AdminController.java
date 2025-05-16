package com.example.jwtapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
public class AdminController {
    
    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "管理者のみアクセス可能な全ユーザー情報");
        response.put("users", "ユーザーリスト");
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/system/config")
    public ResponseEntity<String> updateSystemConfig(@RequestBody Map<String, Object> config) {
        return ResponseEntity.ok("システム設定が更新されました");
    }
    
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        return ResponseEntity.ok("ユーザー " + userId + " が削除されました");
    }
}
