package com.example.jwtapi.servicecontroller;

import com.example.jwtapi.dto.UpdateRequest;
import com.example.jwtapi.exception.CustomException;
import com.example.jwtapi.service.UpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UpdateServiceController {
    
    private final UpdateService updateService;
    
    @Transactional(rollbackFor = Exception.class)
    public void batchUpdate(List<UpdateRequest> requests, String authHeader) {
        // SecurityConfigで既にスコープ検証されているため、ここでの検証は不要
        // ビジネスロジックの実行に集中
        try {
            updateService.batchUpdate(requests);
        } catch (Exception e) {
            throw new CustomException("更新処理に失敗しました: " + e.getMessage(), 500);
        }
    }
}
