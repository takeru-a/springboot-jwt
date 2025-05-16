package com.example.jwtapi.service;

import com.example.jwtapi.dto.UpdateRequest;
import com.example.jwtapi.entity.Item;
import com.example.jwtapi.exception.CustomException;
import com.example.jwtapi.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateService {
    
    private final ItemRepository itemRepository;
    
    public void batchUpdate(List<UpdateRequest> requests) {
        for (UpdateRequest request : requests) {
            Item item = itemRepository.findById(request.getId())
                .orElseThrow(() -> new CustomException("アイテムが見つかりません: ID=" + request.getId(), 404));
            
            item.setName(request.getName());
            item.setDescription(request.getDescription());
            item.setQuantity(request.getQuantity());
            
            itemRepository.save(item);
        }
    }
}
