package com.example.jwtapi.controller;

import com.example.jwtapi.dto.UpdateRequest;
import com.example.jwtapi.servicecontroller.UpdateServiceController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class UpdateController {
    
    private final UpdateServiceController updateServiceController;
    
    @PutMapping("/batch")
    @PreAuthorize("hasAuthority('SCOPE_UPDATE')")
    public ResponseEntity<String> batchUpdate(@Valid @RequestBody List<UpdateRequest> requests,
                                            @RequestHeader("Authorization") String token) {
        updateServiceController.batchUpdate(requests, token);
        return ResponseEntity.ok("更新が完了しました");
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_READ')")
    public ResponseEntity<String> getItem(@PathVariable Long id) {
        // 読み取り処理の実装
        return ResponseEntity.ok("アイテム情報");
    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_DELETE')")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        // 削除処理の実装
        return ResponseEntity.ok("削除が完了しました");
    }
}
